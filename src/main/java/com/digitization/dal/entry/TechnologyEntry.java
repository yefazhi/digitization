package com.digitization.dal.entry;

/**
 * 工艺信息实体
 */
public class TechnologyEntry {

        /***
         * '自增id'
         */
        private Integer id;
        /***
         *'工件编号'
         */
        private Integer number;
        /***
         *'工序号'
         */
        private Integer process;
        /***
         *'批量'
         */
        private Integer batch;
        /***
         *'工序时间'
         */
        private Integer processTime;
        /***
         *'总时间'
         */
        private Integer allTime;
        /***
         *'设备编号'
         */
        private Integer deviceId;

        public TechnologyEntry() {

        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public Integer getProcess() {
            return process;
        }

        public void setProcess(Integer process) {
            this.process = process;
        }

        public Integer getBatch() {
            return batch;
        }

        public void setBatch(Integer batch) {
            this.batch = batch;
        }

        public Integer getProcessTime() {
            return processTime;
        }

        public void setProcessTime(Integer processTime) {
            this.processTime = processTime;
        }

        public Integer getAllTime() {
            return allTime;
        }

        public void setAllTime(Integer allTime) {
            this.allTime = allTime;
        }

        public Integer getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(Integer deviceId) {
            this.deviceId = deviceId;
        }
}
