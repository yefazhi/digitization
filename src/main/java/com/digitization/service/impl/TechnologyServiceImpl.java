package com.digitization.service.impl;

import com.digitization.dal.entry.TechnologyEntry;
import com.digitization.dal.inter.TechnologyDao;
import com.digitization.service.inter.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service("technologyService")
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    private TechnologyDao technologyDao;

    @Override
    public boolean add(TechnologyEntry technologyEntry) {
        return technologyDao.insert(technologyEntry);
    }

    @Override
    public boolean delete(Integer id) {
        return technologyDao.delete(id);
    }

    @Override
    public List<TechnologyEntry> query(TechnologyEntry technologyEntry) {
        List<TechnologyEntry> list = technologyDao.queryList(technologyEntry);
        return CollectionUtils.isEmpty(list) ? Collections.emptyList() : list;
    }
}
