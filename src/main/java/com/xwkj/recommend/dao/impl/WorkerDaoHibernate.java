package com.xwkj.recommend.dao.impl;

import com.xwkj.common.hibernate.BaseHibernateDaoSupport;
import com.xwkj.recommend.dao.WorkerDao;
import com.xwkj.recommend.domain.Worker;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkerDaoHibernate extends BaseHibernateDaoSupport<Worker> implements WorkerDao {

    public WorkerDaoHibernate() {
        super();
        setClass(Worker.class);
    }

    public Worker getByNumber(String number) {
        String hql = "from Worker where number = ?";
        List<Worker> workers = (List<Worker>) getHibernateTemplate().find(hql, number);
        if (workers.size() == 0) {
            return null;
        }
        return workers.get(0);
    }

    public List<Worker> findEnable() {
        String hql = "from Workers where enable = true order order by number";
        return (List<Worker>) getHibernateTemplate().find(hql);
    }



}
