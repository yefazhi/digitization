package com.digitization.dal.entry;

/**
 * 工件信息实体
 */
public class WorkpieceEntry {

        /***
         * 自增id
         */
        private Integer id;
        /***
         * 工件编号
         */
        private Integer number;
        /***
         * 批量
         */
        private Integer batch;
        /***
         * 工件名
         */
        private String name;
        /***
         *供应商
         */
        private String supplier;
        /***
         *工序数
         */
        private Integer process;
        /***
         *交货期
         */
        private String delivery;

        public WorkpieceEntry() {

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

        public Integer getBatch() {
            return batch;
        }

        public void setBatch(Integer batch) {
            this.batch = batch;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSupplier() {
            return supplier;
        }

        public void setSupplier(String supplier) {
            this.supplier = supplier;
        }

        public Integer getProcess() {
            return process;
        }

        public void setProcess(Integer process) {
            this.process = process;
        }

        public String getDelivery() {
            return delivery;
        }

        public void setDelivery(String delivery) {
            this.delivery = delivery;
        }
}
