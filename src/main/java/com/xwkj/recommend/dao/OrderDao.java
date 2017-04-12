package com.xwkj.recommend.dao;

import com.xwkj.common.hibernate.BaseDao;
import com.xwkj.recommend.domain.Order;

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

}
