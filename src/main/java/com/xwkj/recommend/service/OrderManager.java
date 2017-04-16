package com.xwkj.recommend.service;

import com.xwkj.recommend.bean.OrderBean;
import com.xwkj.recommend.domain.Order;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderManager {

    public static final int StateCreate = 0;
    public static final int StateDeliver = 1;
    public static final int StateFinish = 2;
    public static final int StateDeduct = 3;
    public static final int StateAbandon = -1;
    public static final int StateAll = 9;

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
     * Get order bean
     *
     * @param oid
     * @return
     */
    OrderBean getOrder(String oid);

    /**
     * Find all orders in a period and state code.
     *
     * @param start
     * @param end
     * @param state
     * @return
     */
    List<OrderBean> searchIn(String start, String end, int state);


    /**
     * Get all task orders for a worker.
     *
     * @param session
     * @return
     */
    List<OrderBean> getTaskOrders(HttpSession session);

    /**
     * Get orders by state for referrer.
     *
     * @param state
     * @param session
     * @return
     */
    List<OrderBean> getReferrerOrders(int state, HttpSession session);

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
     * Worker finish an order.
     *
     * @param oid
     * @param session
     * @return
     */
    boolean finish(String oid, HttpSession session);

    /**
     * Admin deduct bonus for referrer.
     *
     * @param oid
     * @param price
     * @param deduct
     * @param session
     * @return
     */
    boolean deduct(String oid, int price, int deduct, HttpSession session);

    /**
     * Admin abandon the order.
     *
     * @param oid
     * @param session
     * @return
     */
    boolean abandon(String oid, HttpSession session);

}
