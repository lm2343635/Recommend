package com.xwkj.recommend.dao.impl;

import com.xwkj.common.hibernate.BaseHibernateDaoSupport;
import com.xwkj.recommend.dao.ReferrerDao;
import com.xwkj.recommend.domain.Referrer;
import org.springframework.stereotype.Repository;

@Repository
public class RefererDaoHibernate extends BaseHibernateDaoSupport<Referrer> implements ReferrerDao {

    public RefererDaoHibernate() {
        super();
        setClass(Referrer.class);
    }

}
