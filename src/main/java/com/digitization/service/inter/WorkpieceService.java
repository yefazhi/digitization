package com.digitization.service.inter;

import com.digitization.dal.entry.WorkpieceEntry;

import java.util.List;

public interface WorkpieceService {

    /**
     * 录入
     * @param workpieceEntry
     * @return
     */
    boolean add(WorkpieceEntry workpieceEntry);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 查询
     * @param workpieceEntry
     * @return
     */
    List<WorkpieceEntry> query(WorkpieceEntry workpieceEntry);
}
