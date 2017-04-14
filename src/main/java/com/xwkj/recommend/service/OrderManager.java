package com.xwkj.recommend.service;

import com.xwkj.recommend.bean.OrderBean;
import com.xwkj.recommend.domain.Order;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderManager {

    public static final int StateCreate = 0;
    public static final int StateDeliver = 1;
    public static final int StateFinish = 2;
    public static final int StateEnd = 3;
    public static final int Statebandon = -1;

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

    /**
     * Find all orders in a period.
     *
     * @param start
     * @param end
     * @return
     */
    List<OrderBean> searchIn(String start, String end);

    /**
     * Get order bean
     *
     * @param oid
     * @return
     */
    OrderBean getOrder(String oid);

    /**
     * Admin deliver an order to a worker.
     *
     * @param oid
     * @param wid
     * @param price
     * @param type
     * @param session
     * @return
     */
    boolean deliver(String oid, String wid, int price, String type, HttpSession session);

    /**
     * Get all task orders for a worker.
     *
     * @param session
     * @return
     */
    List<OrderBean> getTaskOrder(HttpSession session);

    /**
     * Worker finish an order.
     *
     * @param oid
     * @param session
     * @return
     */
    boolean workerFinishOrder(String oid, HttpSession session);


}
