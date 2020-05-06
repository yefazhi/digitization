package com.digitization.dto;


public class TaskHistoryDataDTO {

    /**
     * 设备编号
     */
    private String equipmentNumber;
    /**
     * 工序编号
     */
    private String technologyNumber;
    /**
     * 工件编号
     */
    private String workpieceNumber;
    /**
     * 开始时间段
     */
    private String startTime;
    /**
     * 结束时间段
     */
    private String endTime;

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public String getTechnologyNumber() {
        return technologyNumber;
    }

    public void setTechnologyNumber(String technologyNumber) {
        this.technologyNumber = technologyNumber;
    }

    public String getWorkpieceNumber() {
        return workpieceNumber;
    }

    public void setWorkpieceNumber(String workpieceNumber) {
        this.workpieceNumber = workpieceNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
