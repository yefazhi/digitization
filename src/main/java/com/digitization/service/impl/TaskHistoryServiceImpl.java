package com.digitization.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.digitization.dal.entry.TaskHistoryEntry;
import com.digitization.dal.inter.TaskHistoryDao;
import com.digitization.dto.TaskHistoryDTO;
import com.digitization.dto.TaskHistoryDataDTO;
import com.digitization.service.inter.TaskHistoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service("taskHistoryService")
public class TaskHistoryServiceImpl implements TaskHistoryService {

    @Autowired
    private TaskHistoryDao taskHistoryDao;

    @Override
    public boolean add(TaskHistoryEntry taskHistoryEntry) {
        taskHistoryDao.insert(taskHistoryEntry);
        return true;
    }

    @Override
    public boolean delete(String taskId) {
        taskHistoryDao.delete(taskId);
        return true;
    }

    @Override
    public List<TaskHistoryDTO> queryAll() {
        return covert(taskHistoryDao.queryAll());
    }

    @Override
    public TaskHistoryDTO queryOne(String taskId) {
        List<TaskHistoryEntry> TaskHistoryEntryList = taskHistoryDao.queryByTaskId(taskId);
        if (CollectionUtils.isEmpty(TaskHistoryEntryList)) {
            return null;
        }
        return covert(TaskHistoryEntryList.get(0));
    }

    private TaskHistoryDTO covert(TaskHistoryEntry taskHistoryEntry) {
        if (taskHistoryEntry == null) {
            return null;
        }
        TaskHistoryDTO taskHistoryDTO = new TaskHistoryDTO();
        BeanUtils.copyProperties(taskHistoryEntry, taskHistoryDTO);
        if (StringUtils.isNotBlank(taskHistoryEntry.getTaskData())) {
            List<TaskHistoryDataDTO> taskHistoryDataDTOList = JSON.parseObject(taskHistoryEntry.getTaskData(),
                    new TypeReference<List<TaskHistoryDataDTO>>() {});
            taskHistoryDTO.setTaskDataList(taskHistoryDataDTOList);
        }
        return taskHistoryDTO;
    }

    private List<TaskHistoryDTO> covert(List<TaskHistoryEntry> taskHistoryEntryList) {
        if (CollectionUtils.isEmpty(taskHistoryEntryList)) {
            return new ArrayList<>();
        }
        List<TaskHistoryDTO> taskHistoryDTOList = new ArrayList<>();
        for (TaskHistoryEntry entry : taskHistoryEntryList) {
            taskHistoryDTOList.add(covert(entry));
        }
        return taskHistoryDTOList;
    }
}
