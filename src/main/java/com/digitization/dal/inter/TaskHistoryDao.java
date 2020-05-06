package com.digitization.dal.inter;

import com.digitization.dal.entry.TaskHistoryEntry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskHistoryDao {

    boolean insert(TaskHistoryEntry taskHistoryEntry);

    boolean delete(@Param("taskId") String taskId);

    List<TaskHistoryEntry> queryByTaskId(@Param("taskId") String taskId);

    List<TaskHistoryEntry> queryAll();
}
