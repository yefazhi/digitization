package com.digitization.dal.entry;

/***
 * 调度任务历史
 */
public class TaskHistoryEntry {

    /***
     * 自增id
     */
    private Integer id;
    /**
     * '任务编号'
     */
    private String taskId;
    /**
     * '任务执行结果数据'
     */
    private String  taskData;
    /**
     * '任务执行结果图片'
     */
    private String  taskImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskData() {
        return taskData;
    }

    public void setTaskData(String taskData) {
        this.taskData = taskData;
    }

    public String getTaskImage() {
        return taskImage;
    }

    public void setTaskImage(String taskImage) {
        this.taskImage = taskImage;
    }
}
