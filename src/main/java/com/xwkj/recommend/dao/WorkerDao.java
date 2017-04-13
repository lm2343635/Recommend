package com.xwkj.recommend.dao;

import com.xwkj.common.hibernate.BaseDao;
import com.xwkj.recommend.domain.Worker;

import java.util.List;

public interface WorkerDao extends BaseDao<Worker> {

    /**
     * Get a work by his number.
     *
     * @param number
     * @return
     */
    Worker getByNumber(String number);

    /**
     * Find all enbale workers.
     *
     * @return
     */
    List<Worker> findEnable();
}
