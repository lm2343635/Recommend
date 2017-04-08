package com.xwkj.recommend.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recommend_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String oid;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String telephone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String type;

    @Column
    private String remark;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer state;

    @Column(nullable = false)
    private Long createAt;

    @Column
    private Long deliverAt;

    @Column
    private Long finishAt;

    @Column
    private Long endAt;

    @ManyToOne
    @JoinColumn(name = "wid")
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "rid", nullable = false)
    private Referrer referrer;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getDeliverAt() {
        return deliverAt;
    }

    public void setDeliverAt(Long deliverAt) {
        this.deliverAt = deliverAt;
    }

    public Long getFinishAt() {
        return finishAt;
    }

    public void setFinishAt(Long finishAt) {
        this.finishAt = finishAt;
    }

    public Long getEndAt() {
        return endAt;
    }

    public void setEndAt(Long endAt) {
        this.endAt = endAt;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Referrer getReferrer() {
        return referrer;
    }

    public void setReferrer(Referrer referrer) {
        this.referrer = referrer;
    }

}
