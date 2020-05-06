package com.digitization.dal.inter;

import com.digitization.dal.entry.WorkpieceEntry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkpieceDao {

    boolean insert(WorkpieceEntry workpieceEntry);

    boolean delete(@Param("id") Integer id);

    List<WorkpieceEntry> queryList(WorkpieceEntry workpieceEntry);

}
