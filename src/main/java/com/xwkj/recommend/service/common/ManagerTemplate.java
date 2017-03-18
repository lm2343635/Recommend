package com.xwkj.recommend.service.common;

import com.xwkj.recommend.dao.ReferrerDao;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagerTemplate {

    @Autowired
    protected ReferrerDao referrerDao;

    public ReferrerDao getReferrerDao() {
        return referrerDao;
    }

    public void setReferrerDao(ReferrerDao referrerDao) {
        this.referrerDao = referrerDao;
    }

}
