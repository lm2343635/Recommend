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
    private int deduct;
    private int state;
    private Date createAt;
    private Date deliverAt;
    private Date finishAt;
    private Date deductAt;
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

    public int getDeduct() {
        return deduct;
    }

    public void setDeduct(int deduct) {
        this.deduct = deduct;
    }

    public Date getDeductAt() {
        return deductAt;
    }

    public void setDeductAt(Date deductAt) {
        this.deductAt = deductAt;
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
        this.deduct = order.getDeduct();
        this.state = order.getState();
        this.createAt = order.getCreateAt();
        if (!simple) {
            this.address = order.getAddress();
            this.remark = order.getRemark();
            this.deliverAt = order.getDeliverAt();
            this.finishAt = order.getFinishAt();
            this.deductAt = order.getDeductAt();
            this.worker = order.getWorker() == null ? null : new WorkerBean(order.getWorker());
            this.referrer = order.getReferrer() == null ? null : new ReferrerBean(order.getReferrer());
        }
    }
}
