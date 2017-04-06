package com.xwkj.recommend.service.impl;

import com.xwkj.recommend.service.OrderManager;
import com.xwkj.recommend.service.common.ManagerTemplate;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;

@Service
@RemoteProxy(name = "OrderManager")
public class OrderManagerImpl extends ManagerTemplate implements OrderManager {
}
