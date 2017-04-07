package com.xwkj.recommend.service;

import javax.servlet.http.HttpSession;

public interface OrderManager {

    /**
     * Create a new order by referrer.
     *
     * @param name
     * @param telephone
     * @param address
     * @param type
     * @param remark
     * @param session
     * @return
     */
    String create(String name, String telephone, String address, String type, String remark, HttpSession session);

}
