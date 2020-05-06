package com.digitization.service.inter;

import com.digitization.dal.entry.EquipmentEntry;

import java.util.List;

public interface EquipmentService {

    /**
     * 录入
     * @param equipmentEntry
     * @return
     */
    boolean add(EquipmentEntry equipmentEntry);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 查询
     * @param equipmentEntry
     * @return
     */
    List<EquipmentEntry> query(EquipmentEntry equipmentEntry);
}
