package com.digitization.dal.inter;

import com.digitization.dal.entry.TechnologyEntry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyDao {

    boolean insert(TechnologyEntry technologyEntry);

    boolean delete(@Param("id") Integer id);

    List<TechnologyEntry> queryList(TechnologyEntry technologyEntry);
}
