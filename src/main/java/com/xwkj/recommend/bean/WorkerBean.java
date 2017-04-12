package com.xwkj.recommend.bean;

import com.xwkj.recommend.domain.Worker;
import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
public class WorkerBean {

    private String wid;
    private String number;
    private String name;
    private String password;
    private boolean state;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public WorkerBean(Worker worker) {
        this.wid = worker.getWid();
        this.number = worker.getNumber();
        this.name = worker.getName();
        this.password = worker.getPassword();
        this.state = worker.getState();
    }

}
