package com.etc.pfs.entity;

import java.util.Date;

public class Accounts {
    private String id;
    private String icategory;
    private String classif;
    private String remark;
    private Date addtime;
    private String username;
    private Float money;

    @Override
    public String toString() {
        return "Accounts{" +
                "id='" + id + '\'' +
                ", icategory='" + icategory + '\'' +
                ", classif='" + classif + '\'' +
                ", remark='" + remark + '\'' +
                ", addtime=" + addtime +
                ", username='" + username + '\'' +
                ", money=" + money +
                '}';
    }

    public Accounts() {
        super();
    }

    public Accounts(String id, String icategory, String classif, String remark, Date addtime, String username, Float money) {
        this.id = id;
        this.icategory = icategory;
        this.classif = classif;
        this.remark = remark;
        this.addtime = addtime;
        this.username = username;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcategory() {
        return icategory;
    }

    public void setIcategory(String icategory) {
        this.icategory = icategory;
    }

    public String getClassif() {
        return classif;
    }

    public void setClassif(String classif) {
        this.classif = classif;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }
}
