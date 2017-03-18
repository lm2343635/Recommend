package com.xwkj.recommend.service.impl;

import com.xwkj.recommend.domain.Referrer;
import com.xwkj.recommend.service.ReferrerService;
import com.xwkj.recommend.service.common.ManagerTemplate;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.transaction.annotation.Transactional;

@RemoteProxy(name = "ReferrerManager")
public class ReferrerServiceImpl extends ManagerTemplate implements ReferrerService {

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

}
