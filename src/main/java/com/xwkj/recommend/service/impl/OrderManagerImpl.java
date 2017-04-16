package com.xwkj.recommend.service.impl;

import com.xwkj.common.util.DateTool;
import com.xwkj.common.util.Debug;
import com.xwkj.common.util.MathTool;
import com.xwkj.recommend.bean.OrderBean;
import com.xwkj.recommend.domain.Order;
import com.xwkj.recommend.domain.Referrer;
import com.xwkj.recommend.domain.Worker;
import com.xwkj.recommend.service.OrderManager;
import com.xwkj.recommend.service.common.ManagerTemplate;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RemoteProxy(name = "OrderManager")
public class OrderManagerImpl extends ManagerTemplate implements OrderManager {

    @RemoteMethod
    @Transactional
    public String create(String name, String telephone, String address, String type, String remark, HttpSession session) {
        Referrer referrer = getReferrerFromSession(session);
        if (referrer == null) {
            Debug.error("Cannot get referrer from session.");
            return null;
        }
        Order order = new Order();
        order.setNumber(DateTool.formatDate(new Date(), "yyyyMMddHHmmss") + MathTool.getRandomStr(6));
        order.setName(name);
        order.setTelephone(telephone);
        order.setAddress(address);
        order.setType(type);
        order.setRemark(remark);
        order.setPrice(0);
        order.setDeduct(0);
        order.setState(StateCreate);
        order.setCreateAt(new Date());
        order.setReferrer(referrer);
        if (orderDao.save(order) == null) {
            Debug.error("Create new order internal error.");
            return null;
        }
        return order.getNumber();
    }

    @RemoteMethod
    public List<OrderBean> searchIn(String start, String end) {
        Date startDate = DateTool.transferDate(start, DateTool.YEAR_MONTH_DATE_FORMAT);
        Date endDate = DateTool.transferDate(end, DateTool.YEAR_MONTH_DATE_FORMAT);
        List<OrderBean> orderBeans = new ArrayList<OrderBean>();
        for (Order order : orderDao.findByStartEnd(startDate, endDate)) {
            orderBeans.add(new OrderBean(order, true));
        }
        return orderBeans;
    }

    @RemoteMethod
    public List<OrderBean> getTaskOrders(HttpSession session) {
        Worker worker = getWorkerFromSession(session);
        if (worker == null) {
            return null;
        }
        List<OrderBean> orderBeans = new ArrayList<OrderBean>();
        for (Order order : orderDao.findByWorker(worker, StateDeliver)) {
            orderBeans.add(new OrderBean(order, false));
        }
        return orderBeans;
    }

    @RemoteMethod
    public List<OrderBean> getReferrerOrders(int state, HttpSession session) {
        Referrer referrer = getReferrerFromSession(session);
        if (referrer == null) {
            return null;
        }
        List<OrderBean> orderBeans = new ArrayList<OrderBean>();
        for (Order order : orderDao.findByStateForReferrer(state, referrer)) {
            orderBeans.add(new OrderBean(order, true));
        }
        return orderBeans;
    }

    @RemoteMethod
    public OrderBean getOrder(String oid) {
        Order order = orderDao.get(oid);
        if (order == null) {
            Debug.error("Cannot get order object by this oid.");
            return null;
        }
        return new OrderBean(order, false);
    }

    @RemoteMethod
    @Transactional
    public boolean deliver(String oid, String wid, int price, String type, HttpSession session) {
        if (!checkAdminSession(session)) {
            return false;
        }
        Order order = orderDao.get(oid);
        if (order == null) {
            Debug.error("Cannot get order by this oid.");
            return false;
        }
        if (order.getState() != StateCreate) {
            Debug.error("Order cannot be deliverd if state is not StateCreate.");
            return false;
        }
        Worker worker = workerDao.get(wid);
        if (worker == null) {
            Debug.error("Cannot get worker by this wid.");
            return false;
        }
        order.setWorker(worker);
        order.setPrice(price);
        order.setType(type);
        order.setDeliverAt(new Date());
        order.setState(StateDeliver);
        orderDao.update(order);
        return true;
    }

    @RemoteMethod
    @Transactional
    public boolean finish(String oid, HttpSession session) {
        Worker worker = getWorkerFromSession(session);
        if (worker == null) {
            return false;
        }
        Order order = orderDao.get(oid);
        if (order == null) {
            Debug.error("Cannot find the order by this oid.");
            return false;
        }
        if (order.getWorker() != worker) {
            Debug.error("This worker has no privilege to finish the order, because admin has not delivered the order the order to this worker.");
            return false;
        }
        if (order.getState() != StateDeliver) {
            Debug.error("Order cannot be finished if state is not StateDeliver.");
            return false;
        }
        order.setState(StateFinish);
        order.setFinishAt(new Date());
        orderDao.update(order);
        return true;
    }

    @RemoteMethod
    @Transactional
    public boolean deduct(String oid, int price, int deduct, HttpSession session) {
        if (!checkAdminSession(session)) {
            return false;
        }
        Order order = orderDao.get(oid);
        if (order == null) {
            Debug.error("Cannot get order by this oid.");
            return false;
        }
        if (order.getState() != StateFinish) {
            Debug.error("Order cannot be deducted if state is not StateFinish.");
            return false;
        }
        order.setPrice(price);
        order.setDeduct(deduct);
        order.setDeductAt(new Date());
        order.setState(StateDeduct);
        orderDao.update(order);
        orderDao.update(order);
        // Add balance for referrer.
        Referrer referrer = order.getReferrer();
        referrer.setBalance(referrer.getBalance() + order.getDeduct());
        referrerDao.update(referrer);
        return true;
    }

    @RemoteMethod
    @Transactional
    public boolean abandon(String oid, HttpSession session) {
        if (!checkAdminSession(session)) {
            return false;
        }
        Order order = orderDao.get(oid);
        if (order == null) {
            Debug.error("Cannot get order by this oid.");
            return false;
        }
        if (order.getState() == StateDeduct) {
            Debug.error("Order cannot be abondoned if state is StateDeduct.");
            return false;
        }
        order.setState(StateAbandon);
        return true;
    }
}
