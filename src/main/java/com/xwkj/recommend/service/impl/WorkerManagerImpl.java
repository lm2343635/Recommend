package com.xwkj.recommend.service.impl;

import com.xwkj.recommend.service.WorkerManager;
import com.xwkj.recommend.service.common.ManagerTemplate;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;

@Service
@RemoteProxy(name = "WorkerManager")
public class WorkerManagerImpl extends ManagerTemplate implements WorkerManager {
}
