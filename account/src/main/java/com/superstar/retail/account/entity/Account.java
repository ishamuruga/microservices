package com.superstar.retail.account.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accNbr;

    private String customerName;

    private Double balance;

    private String type;

    private String status;

    private String ccy;

    public int getAccNbr() {
        return accNbr;
    }

    public void setAccNbr(int accNbr) {
        this.accNbr = accNbr;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account [accNbr=" + accNbr + ", balance=" + balance + ", customerName=" + customerName + ", status="
                + status + ", type=" + type + "]";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }



}
