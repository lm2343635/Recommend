package com.xwkj.recommend.service.impl;

import com.xwkj.recommend.bean.ReferrerBean;
import com.xwkj.recommend.domain.Referrer;
import com.xwkj.recommend.service.ReferrerManager;
import com.xwkj.recommend.service.common.ManagerTemplate;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RemoteProxy(name = "ReferrerManager")
public class ReferrerManagerImpl extends ManagerTemplate implements ReferrerManager {

    @RemoteMethod
    @Transactional
    public boolean register(String telephone, String password, String name, String wechat) {
        if (isTelephoneExist(telephone)) {
            return false;
        }
        Referrer referrer = new Referrer();
        referrer.setTelephone(telephone);
        referrer.setPassword(password);
        referrer.setName(name);
        referrer.setWechat(wechat);
        referrer.setBalance(0);
        referrer.setApplying(false);
        return referrerDao.save(referrer) != null;
    }

    @RemoteMethod
    public boolean isTelephoneExist(String telephone) {
        Referrer referrer = referrerDao.getRefferByTelephone(telephone);
        return referrer != null;
    }

    @RemoteMethod
    public List<ReferrerBean> getAll() {
        List<ReferrerBean> referrerBeans = new ArrayList<ReferrerBean>();
        for (Referrer referrer : referrerDao.findAll()) {
            referrerBeans.add(new ReferrerBean(referrer));
        }
        return referrerBeans;
    }

    @RemoteMethod
    public boolean login(String telephone, String password, HttpSession session) {
        Referrer referrer = referrerDao.getRefferByTelephone(telephone);
        if (referrer == null) {
            return false;
        }
        if (!referrer.getPassword().equals(password)) {
            return false;
        }
        session.setAttribute(ReferrerFlag, referrer.getRid());
        return true;
    }

    public ReferrerBean checkSession(HttpSession session) {
        Referrer referrer = getReferrerFromSession(session);
        if (referrer == null) {
            return null;
        }
        return new ReferrerBean(referrer);
    }

}
