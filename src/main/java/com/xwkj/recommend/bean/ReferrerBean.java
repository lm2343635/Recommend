package com.xwkj.recommend.bean;

import com.xwkj.recommend.domain.Referrer;
import org.directwebremoting.annotations.DataTransferObject;

import javax.persistence.Column;

@DataTransferObject
public class ReferrerBean {

    private String rid;
    private String telephone;
    private String name;
    private String wechat;
    private int balance;
    private boolean applying;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isApplying() {
        return applying;
    }

    public void setApplying(boolean applying) {
        this.applying = applying;
    }

    public ReferrerBean(Referrer referrer) {
        this.rid = referrer.getRid();
        this.telephone = referrer.getTelephone();
        this.name = referrer.getName();
        this.wechat = referrer.getWechat();
        this.balance = referrer.getBalance();
        this.applying = referrer.getApplying();
    }
}
