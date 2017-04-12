package com.xwkj.recommend.service;

import com.xwkj.recommend.bean.ReferrerBean;
import com.xwkj.recommend.domain.Referrer;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ReferrerManager {

    public static final String ReferrerFlag = "4028e00c5b4714721d8570000b71015b";

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
     * Get all user for admin
     *
     * @param session
     * @return
     */
    List<ReferrerBean> getAll(HttpSession session);

    /**
     * User login
     *
     * @param telephone
     * @param password
     * @param session
     * @return
     */
    boolean login(String telephone, String password, HttpSession session);

    /**
     * 
     * @param session
     * @return
     */
    ReferrerBean checkSession(HttpSession session);

}
