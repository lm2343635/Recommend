package com.xwkj.recommend.service;

import com.xwkj.recommend.bean.ReferrerBean;

import java.util.List;

public interface ReferrerManager {

    /**
     * Register a referrer with telephone and password.
     *
     * @param telephone
     * @param password
     * @param name
     * @param wechat
     * @return
     */
    boolean register(String telephone, String password, String name, String wechat);

    /**
     * Test this telephone is exist or not.
     *
     * @param telephone
     * @return
     */
    boolean isTelephoneExist(String telephone);

    /**
     *
     * @return
     */
    List<ReferrerBean> getAll();

}
