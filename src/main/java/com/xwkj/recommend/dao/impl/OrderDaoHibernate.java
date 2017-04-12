package com.xwkj.recommend.dao.impl;

import com.xwkj.common.hibernate.BaseHibernateDaoSupport;
import com.xwkj.recommend.dao.OrderDao;
import com.xwkj.recommend.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class OrderDaoHibernate extends BaseHibernateDaoSupport<Order> implements OrderDao {

    public OrderDaoHibernate() {
        super();
        setClass(Order.class);
    }

    public List<Order> findByStartEnd(Date start, Date end) {
        String hql = "from Order where createAt >= ? and createAt <= ?";
        return (List<Order>) getHibernateTemplate().find(hql, start, end);
    }

}
