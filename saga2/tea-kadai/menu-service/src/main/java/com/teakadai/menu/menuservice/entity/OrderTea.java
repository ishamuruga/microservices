package com.teakadai.menu.menuservice.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tbl_ordertea")
public class OrderTea {
    @Id
    private String id;

    private Boolean isSugarFree;

    private Boolean isSpecialTea;

    private int count;

    private String txnRefNumber;

    private Boolean isSucess;

    private String userid;

    public Boolean getIsSugarFree() {
        return isSugarFree;
    }

    public void setIsSugarFree(Boolean isSugarFree) {
        this.isSugarFree = isSugarFree;
    }

    public Boolean getIsSpecialTea() {
        return isSpecialTea;
    }

    public void setIsSpecialTea(Boolean isSpecialTea) {
        this.isSpecialTea = isSpecialTea;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTxnRefNumber() {
        return txnRefNumber;
    }

    public void setTxnRefNumber(String txnRefNumber) {
        this.txnRefNumber = txnRefNumber;
    }


    public Boolean getIsSucess() {
        return isSucess;
    }

    public void setIsSucess(Boolean isSucess) {
        this.isSucess = isSucess;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "OrderTea [count=" + count + ", id=" + id + ", isSpecialTea=" + isSpecialTea + ", isSucess=" + isSucess
                + ", isSugarFree=" + isSugarFree + ", txnRefNumber=" + txnRefNumber + ", userid=" + userid + "]";
    }





    
}
