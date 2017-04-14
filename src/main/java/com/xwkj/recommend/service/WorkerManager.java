package com.xwkj.recommend.service;

import com.xwkj.recommend.bean.WorkerBean;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface WorkerManager {

    public static final String WorkerFlag = "05b3dfd95b61d061594015b00d9061b0";

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

    /**
     * Worker login.
     *
     * @param number
     * @param password
     * @param session
     * @return
     */
    boolean login(String number, String password, HttpSession session);

    /**
     * Check worker session.
     *
     * @param session
     * @return
     */
    WorkerBean checkSession(HttpSession session);

}
