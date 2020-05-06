package com.digitization.service.impl;

import com.digitization.dal.entry.WorkpieceEntry;
import com.digitization.dal.inter.WorkpieceDao;
import com.digitization.service.inter.WorkpieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service("workpieceService")
public class WorkpieceServiceImpl implements WorkpieceService {

    @Autowired
    private WorkpieceDao workpieceDao;

    @Override
    public boolean add(WorkpieceEntry workpieceEntry) {
        return workpieceDao.insert(workpieceEntry);
    }

    @Override
    public boolean delete(Integer id) {
        return workpieceDao.delete(id);
    }

    @Override
    public List<WorkpieceEntry> query(WorkpieceEntry workpieceEntry) {
        List<WorkpieceEntry> list = workpieceDao.queryList(workpieceEntry);
        return CollectionUtils.isEmpty(list) ? Collections.emptyList() : list;
    }
}
