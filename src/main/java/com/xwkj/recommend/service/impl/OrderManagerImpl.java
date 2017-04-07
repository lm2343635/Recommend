package com.xwkj.recommend.service.impl;

import com.xwkj.common.util.DateTool;
import com.xwkj.common.util.Debug;
import com.xwkj.common.util.MathTool;
import com.xwkj.recommend.domain.Order;
import com.xwkj.recommend.domain.Referrer;
import com.xwkj.recommend.service.OrderManager;
import com.xwkj.recommend.service.common.ManagerTemplate;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;

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
        order.setState(0);
        order.setCreateAt(System.currentTimeMillis());
        order.setReferrer(referrer);
        if (orderDao.save(order) == null) {
            Debug.error("Create new order internal error.");
            return null;
        }
        return order.getNumber();
    }

}
