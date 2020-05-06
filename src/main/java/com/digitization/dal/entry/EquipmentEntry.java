package com.digitization.dal.entry;

/**
 * 工件信息实体
 */
public class EquipmentEntry {

        /***
         * 自增id
         */
        private Integer id;
        /**
         * '设备编号'
         */
        private Integer number;
        /**
         * '设备型号'
         */
        private String  model;
        /**
         *'设备类型'
         */
        private String  type;
        /**
         *'操作人员'
         */
        private String  operation;
        /**
         *'联系电话'
         */
        private String  phone;

        public EquipmentEntry() {

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

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
}
