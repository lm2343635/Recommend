package com.xwkj.recommend.dao.impl;

import com.xwkj.common.hibernate.BaseHibernateDaoSupport;
import com.xwkj.recommend.dao.OrderDao;
import com.xwkj.recommend.domain.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoHibernate extends BaseHibernateDaoSupport<Order> implements OrderDao {

    public OrderDaoHibernate() {
        super();
        setClass(Order.class);
    }

}
