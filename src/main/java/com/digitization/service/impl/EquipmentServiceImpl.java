package com.digitization.service.impl;

import com.digitization.dal.entry.EquipmentEntry;
import com.digitization.dal.entry.TechnologyEntry;
import com.digitization.dal.inter.EquipmentDao;
import com.digitization.service.inter.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentDao equipmentDao;

    @Override
    public boolean add(EquipmentEntry equipmentEntry) {
        return equipmentDao.insert(equipmentEntry);
    }

    @Override
    public boolean delete(Integer id) {
        return equipmentDao.delete(id);
    }

    @Override
    public List<EquipmentEntry> query(EquipmentEntry equipmentEntry) {
        List<EquipmentEntry> list = equipmentDao.queryList(equipmentEntry);
        return CollectionUtils.isEmpty(list) ? Collections.emptyList() : list;
    }
}
