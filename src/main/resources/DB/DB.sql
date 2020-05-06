# 创建数据库
create database digitization;

# 创建工件信息表
CREATE TABLE `workpiece_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `number` int(11) NOT NULL COMMENT '工件编号',
  `batch` int(11) NOT NULL COMMENT '批量',
  `name` varchar(100) NOT NULL COMMENT '工件名',
  `supplier` varchar(100) NOT NULL COMMENT '供应商',
  `process` int(11) DEFAULT NULL COMMENT '工序数',
  `delivery` varchar(100) DEFAULT NULL COMMENT '交货期',
  PRIMARY KEY (`id`),
  KEY `idx_number` (`number`),
  KEY `idx_batch` (`batch`),
  KEY `idx_name` (`name`),
  KEY `idx_supplier` (`supplier`),
  KEY `idx_process` (`process`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT '工件信息表';

# 创建设备信息表
CREATE TABLE `equipment_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `number` int(11) NOT NULL COMMENT '设备编号',
  `model` varchar(100) NOT NULL COMMENT '设备型号',
  `type` varchar(100) NOT NULL COMMENT '设备类型',
  `operation` varchar(50) NOT NULL COMMENT '操作人员',
  `phone` varchar(20) NOT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`),
  KEY `idx_number` (`number`),
  KEY `idx_model` (`model`),
  KEY `idx_type` (`type`),
  KEY `idx_operation` (`operation`),
  KEY `idx_phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT '设备信息表';

# 创建工艺信息表
CREATE TABLE `technology_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `number` int(11) NOT NULL COMMENT '工件编号',
  `process` int(11) DEFAULT NULL COMMENT '工序号',
  `batch` int(11) NOT NULL COMMENT '批量',
  `process_time`  int(11) NOT NULL COMMENT '工序时间',
  `all_time`  int(11) NOT NULL COMMENT '总时间',
  `device_id` int(11) DEFAULT NULL COMMENT '设备编号',
  PRIMARY KEY (`id`),
  KEY `idx_number` (`number`),
  KEY `idx_process` (`process`),
  KEY `idx_batch` (`batch`),
  KEY `idx_process_time` (`process_time`),
  KEY `idx_all_time` (`all_time`),
  KEY `idx_device_id` (`device_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT '工艺信息表';


# 创建历史任务表
CREATE TABLE `task_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `task_id` varchar (100) NOT NULL COMMENT '任务编号',
  `task_data` text DEFAULT NULL COMMENT '运行结果数据',
  `task_image` longtext DEFAULT NULL COMMENT '运行结果图片信息'
  PRIMARY KEY (`id`),
  KEY `idx_task_id` (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT '历史任务表';