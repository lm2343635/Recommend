package com.xwkj.recommend.dao.impl;

import com.xwkj.common.hibernate.BaseHibernateDaoSupport;
import com.xwkj.recommend.dao.OrderDao;
import com.xwkj.recommend.domain.Order;
import com.xwkj.recommend.domain.Referrer;
import com.xwkj.recommend.domain.Worker;
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
        String hql = "from Order where createAt >= ? and createAt <= ? order by createAt desc";
        return (List<Order>) getHibernateTemplate().find(hql, start, end);
    }

    public List<Order> findByStartEndWithState(Date start, Date end, int state) {
        String hql = "from Order where createAt >= ? and createAt <= ? and state = ? order by createAt desc";
        return (List<Order>) getHibernateTemplate().find(hql, start, end, state);
    }

    public List<Order> findByWorker(Worker worker, int state) {
        String hql = "from Order where worker = ? and state = ? order by createAt desc";
        return (List<Order>) getHibernateTemplate().find(hql, worker, state);
    }

    public List<Order> findByStateForReferrer(int state, Referrer referrer) {
        String hql = "from Order where state = ? and referrer = ? order by createAt desc";
        return (List<Order>) getHibernateTemplate().find(hql, state, referrer);
    }

}
