package com.xwkj.recommend.bean;

import com.xwkj.recommend.domain.Order;
import org.directwebremoting.annotations.DataTransferObject;

import java.util.Date;

@DataTransferObject
public class OrderBean {

    private String oid;
    private String number;
    private String name;
    private String telephone;
    private String address;
    private String type;
    private String remark;
    private int price;
    private int state;
    private Date createAt;
    private Date deliverAt;
    private Date finishAt;
    private Date endAt;
    private WorkerBean worker;
    private ReferrerBean referrer;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getDeliverAt() {
        return deliverAt;
    }

    public void setDeliverAt(Date deliverAt) {
        this.deliverAt = deliverAt;
    }

    public Date getFinishAt() {
        return finishAt;
    }

    public void setFinishAt(Date finishAt) {
        this.finishAt = finishAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public WorkerBean getWorker() {
        return worker;
    }

    public void setWorker(WorkerBean worker) {
        this.worker = worker;
    }

    public ReferrerBean getReferrer() {
        return referrer;
    }

    public void setReferrer(ReferrerBean referrer) {
        this.referrer = referrer;
    }

    /**
     * OrderBean constructer
     *
     * @param order persistent object
     * @param simple If simple is true, only return basic information.
     */
    public OrderBean(Order order, boolean simple) {
        this.oid = order.getOid();
        this.number = order.getNumber();
        this.name = order.getName();
        this.telephone = order.getTelephone();
        this.type = order.getType();
        this.price = order.getPrice();
        this.state = order.getState();
        this.createAt = new Date(order.getCreateAt());
        if (!simple) {
            this.address = order.getAddress();
            this.remark = order.getRemark();
            this.deliverAt = order.getDeliverAt() == null ? null : new Date(order.getDeliverAt());
            this.finishAt = order.getFinishAt() == null ? null : new Date(order.getFinishAt());
            this.endAt = order.getEndAt() == null ? null : new Date(order.getEndAt());
            this.worker = order.getWorker() == null ? null : new WorkerBean();
            this.referrer = order.getReferrer() == null ? null : new ReferrerBean(order.getReferrer());
        }
    }
}
