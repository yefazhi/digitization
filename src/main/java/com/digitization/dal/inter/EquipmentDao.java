package com.digitization.dal.inter;

import com.digitization.dal.entry.EquipmentEntry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EquipmentDao {

    boolean insert(EquipmentEntry equipmentEntry);

    boolean delete(@Param("id") Integer id);

    List<EquipmentEntry> queryList(EquipmentEntry equipmentEntry);
}
