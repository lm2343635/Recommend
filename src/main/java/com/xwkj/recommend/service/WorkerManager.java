package com.xwkj.recommend.service;

import com.xwkj.recommend.bean.WorkerBean;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface WorkerManager {

    /**
     * Add a new worker
     *
     * @param number
     * @param name
     * @param password
     * @return If worker's number is existed, return false;
     */
    boolean addWorker(String number, String name, String password);

    /**
     * Get all worker for admin
     *
     * @param onlyEnable
     * @param session
     * @return
     */
    List<WorkerBean> getWorkers(boolean onlyEnable, HttpSession session);


    /**
     * Change worker state.
     *
     * @param wid
     * @param state
     * @param session
     * @return
     */
    boolean changeState(String wid, boolean state, HttpSession session);

}
