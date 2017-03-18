package com.xwkj.recommend.dao.impl;

import com.xwkj.common.hibernate.BaseHibernateDaoSupport;
import com.xwkj.recommend.dao.ReferrerDao;
import com.xwkj.recommend.domain.Referrer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RefererDaoHibernate extends BaseHibernateDaoSupport<Referrer> implements ReferrerDao {

    public RefererDaoHibernate() {
        super();
        setClass(Referrer.class);
    }

    public Referrer getRefferByTelephone(String telephone) {
        String hql = "from Referrer where telephone = ?";
        List<Referrer> referrers = (List<Referrer>) getHibernateTemplate().find(hql, telephone);
        if (referrers.size() == 0) {
            return null;
        }
        return referrers.get(0);
    }

}
