package com.digitization.service.inter;

import com.digitization.dal.entry.TechnologyEntry;

import java.util.List;

public interface TechnologyService {

    /**
     * 录入
     * @param technologyEntry
     * @return
     */
    boolean add(TechnologyEntry technologyEntry);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 查询
     * @param technologyEntry
     * @return
     */
    List<TechnologyEntry> query(TechnologyEntry technologyEntry);
}
