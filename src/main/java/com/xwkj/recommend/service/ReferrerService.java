package com.xwkj.recommend.service;

public interface ReferrerService {

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

}
