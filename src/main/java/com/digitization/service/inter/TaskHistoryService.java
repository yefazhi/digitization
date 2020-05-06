package com.digitization.service.inter;

import com.digitization.dal.entry.TaskHistoryEntry;
import com.digitization.dto.TaskHistoryDTO;

import java.util.List;

public interface TaskHistoryService {

    /**
     * 录入
     */
    boolean add(TaskHistoryEntry taskHistoryEntry);

    /**
     * 删除
     */
    boolean delete(String taskId);

    /**
     * 查询全部
     */
    List<TaskHistoryDTO> queryAll();

    /**
     * 查询指定taskId对应的任务数据
     */
    TaskHistoryDTO queryOne(String taskId);
}
