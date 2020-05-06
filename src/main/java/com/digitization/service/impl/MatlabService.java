package com.digitization.service.impl;


import com.alibaba.fastjson.JSON;
import com.digitization.dal.entry.TaskHistoryEntry;
import com.digitization.dal.entry.TechnologyEntry;
import com.digitization.dal.inter.TechnologyDao;
import com.digitization.dto.TaskHistoryDataDTO;
import com.digitization.service.inter.TaskHistoryService;
import com.digitization.util.IDUtil;
import com.digitization.util.ImageUtil;
import org.n52.matlab.control.MatlabProxy;
import org.n52.matlab.control.extensions.MatlabNumericArray;
import org.n52.matlab.control.extensions.MatlabTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatlabService {

    @Autowired
    private TechnologyDao technologyDao;

    @Autowired
    private MatlabProxy matlabProxy;

    @Autowired
    private TaskHistoryService taskHistoryService;

    @Value("${matlab.file.path}")
    private String matlabFilePath;

    public String run() {
        String taskId = IDUtil.generateId("TASK-");
        System.out.println("开始调度任务，当前任务编号:"+taskId);
        try {
            TechnologyEntry technologyEntry = new TechnologyEntry();
            // 获取全部工艺参数
            List<TechnologyEntry> data = technologyDao.queryList(technologyEntry);
            // 构造Matlab入参
            double[][] requestData = new double[data.size()][6];
            for (int i = 0; i < data.size(); i++) {
                 requestData[i][0] = data.get(i).getNumber();
                 requestData[i][1] = data.get(i).getProcess();
                 requestData[i][2] = data.get(i).getBatch();
                 requestData[i][3] = data.get(i).getProcessTime();
                 requestData[i][4] = data.get(i).getAllTime();
                 requestData[i][5] = data.get(i).getDeviceId();
            }
            MatlabNumericArray input = new MatlabNumericArray(requestData, null);
            MatlabTypeConverter converter = new MatlabTypeConverter(matlabProxy);
            converter.setNumericArray("in", input);
            // 调用Matlab程序
            matlabProxy.eval("[out]=main(in)");
            // 获取Matlab程序返回结果
            double[][] out = converter.getNumericArray("out").getRealArray2D();
            // 任务执行结果数据解析，入库
            List<TaskHistoryDataDTO> taskHistoryDataDTOS = new ArrayList<>();
            for (int i = 0; i < out.length; i++) {
                TaskHistoryDataDTO taskHistoryData = new TaskHistoryDataDTO();
                taskHistoryData.setTechnologyNumber(replace(String.valueOf(out[i][0])));
                taskHistoryData.setWorkpieceNumber(replace(String.valueOf(out[i][1])));
                taskHistoryData.setEquipmentNumber(replace(String.valueOf(out[i][4])));
                taskHistoryData.setStartTime(replace(String.valueOf(out[i][2])));
                taskHistoryData.setEndTime(replace(String.valueOf(out[i][3])));
                taskHistoryDataDTOS.add(taskHistoryData);
            }
            TaskHistoryEntry taskHistoryEntry = new TaskHistoryEntry();
            taskHistoryEntry.setTaskId(taskId);
            taskHistoryEntry.setTaskImage(ImageUtil.encodeImageToBase64(matlabFilePath+"\\img.jpg"));
            taskHistoryEntry.setTaskData(JSON.toJSONString(taskHistoryDataDTOS));
            taskHistoryService.add(taskHistoryEntry);
            System.out.println("matlab执行结束");
            System.out.println("调度任务执行成功，当前任务编号:"+taskId);
            return taskId;
        } catch (Exception e) {
            System.out.println("调度任务执行失败，当前任务编号:"+taskId);
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 使用java正则表达式去掉多余的.与0
     * @param s
     * @return  string
     */
    public static String replace(String s){
        if(null != s && s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }
}
