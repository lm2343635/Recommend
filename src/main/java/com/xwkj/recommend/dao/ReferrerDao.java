package com.xwkj.recommend.dao;

import com.xwkj.common.hibernate.BaseDao;
import com.xwkj.recommend.domain.Referrer;

public interface ReferrerDao extends BaseDao<Referrer> {

    /**
     * Get reffer by telephone.
     * Test this telephone is exist or not.
     *
     * @param telephone
     * @return
     */
    Referrer getRefferByTelephone(String telephone);

}
