package com.xwkj.recommend.service.impl;

import com.xwkj.common.util.Debug;
import com.xwkj.recommend.bean.WorkerBean;
import com.xwkj.recommend.domain.Worker;
import com.xwkj.recommend.service.WorkerManager;
import com.xwkj.recommend.service.common.ManagerTemplate;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
@RemoteProxy(name = "WorkerManager")
public class WorkerManagerImpl extends ManagerTemplate implements WorkerManager {

    @RemoteMethod
    @Transactional
    public boolean addWorker(String number, String name, String password) {
        Worker worker = workerDao.getByNumber(number);
        if (worker != null) {
            return false;
        }
        worker = new Worker();
        worker.setNumber(number);
        worker.setName(name);
        worker.setPassword(password);
        worker.setState(true);
        workerDao.save(worker);
        return true;
    }

    @RemoteMethod
    public List<WorkerBean> getAll(HttpSession session) {
        if (!checkAdminSession(session)) {
            return null;
        }
        List<WorkerBean> workerBeans = new ArrayList<WorkerBean>();
        for (Worker worker : workerDao.findAll("number", false)) {
            workerBeans.add(new WorkerBean(worker));
        }
        return workerBeans;
    }

    @RemoteMethod
    @Transactional
    public boolean changeState(String wid, boolean state, HttpSession session) {
        if (!checkAdminSession(session)) {
            return false;
        }
        Worker worker = workerDao.get(wid);
        if (worker == null) {
            Debug.error("Cannot find this worker by this wid.");
            return false;
        }
        worker.setState(state);
        workerDao.update(worker);
        return true;
    }
}
