package com.xwkj.recommend.dao;

import com.xwkj.common.hibernate.BaseDao;
import com.xwkj.recommend.domain.Order;
import com.xwkj.recommend.domain.Referrer;
import com.xwkj.recommend.domain.Worker;

import java.util.Date;
import java.util.List;

public interface OrderDao extends BaseDao<Order> {

    /**
     * Find order by start date and end date
     *
     * @param start
     * @param end
     * @return
     */
    List<Order> findByStartEnd(Date start, Date end);

    /**
     * Find order by worker and state code
     *
     * @param worker
     * @return
     */
    List<Order> findByWorker(Worker worker, int state);

    /**
     * Find order by state and referrer
     *
     * @param state
     * @param referrer
     * @return
     */
    List<Order> findByStateForReferrer(int state, Referrer referrer);
}
