package com.digitization.dto;

import java.util.List;

public class TaskHistoryDTO {

    /**
     * '任务编号'
     */
    private String taskId;
    /**
     * '任务执行结果数据'
     */
    private List<TaskHistoryDataDTO> taskDataList;
    /**
     * '任务执行结果图片'
     */
    private String  taskImage;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public List<TaskHistoryDataDTO> getTaskDataList() {
        return taskDataList;
    }

    public void setTaskDataList(List<TaskHistoryDataDTO> taskDataList) {
        this.taskDataList = taskDataList;
    }

    public String getTaskImage() {
        return taskImage;
    }

    public void setTaskImage(String taskImage) {
        this.taskImage = taskImage;
    }
}
