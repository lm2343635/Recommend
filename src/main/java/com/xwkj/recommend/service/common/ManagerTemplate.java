package com.xwkj.recommend.service.common;

import com.xwkj.recommend.dao.OrderDao;
import com.xwkj.recommend.dao.ReferrerDao;
import com.xwkj.recommend.dao.WorkerDao;
import com.xwkj.recommend.domain.Referrer;
import com.xwkj.recommend.service.AdminManager;
import com.xwkj.recommend.service.ReferrerManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class ManagerTemplate {

    @Autowired
    protected ReferrerDao referrerDao;

    @Autowired
    protected OrderDao orderDao;

    @Autowired
    protected WorkerDao workerDao;

    public ReferrerDao getReferrerDao() {
        return referrerDao;
    }

    public void setReferrerDao(ReferrerDao referrerDao) {
        this.referrerDao = referrerDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public WorkerDao getWorkerDao() {
        return workerDao;
    }

    public void setWorkerDao(WorkerDao workerDao) {
        this.workerDao = workerDao;
    }

    public boolean checkAdminSession(HttpSession session) {
        return session.getAttribute(AdminManager.ADMIN_FLAG) != null;
    }

    public Referrer getReferrerFromSession(HttpSession session) {
        if (session.getAttribute(ReferrerManager.ReferrerFlag) == null) {
            return null;
        }
        String rid = (String) session.getAttribute(ReferrerManager.ReferrerFlag);
        return referrerDao.get(rid);
    }
}
