package com.superstarbank.vomodel.simplepayment;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.superstarbank.vomodel.BaseVo;

public class SimplePaymentRequest extends BaseVo {

    private int id;

    private String srcAcct;

    private String destAcct;

     
    public SimplePaymentRequest() {
    }



    private int amount;

    private String ccy;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date ts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrcAcct() {
        return srcAcct;
    }

    public void setSrcAcct(String srcAcct) {
        this.srcAcct = srcAcct;
    }

    public String getDestAcct() {
        return destAcct;
    }

    public void setDestAcct(String destAcct) {
        this.destAcct = destAcct;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }


    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }



    @Override
    public String toString() {
        return "SimplePaymentRequest [amount=" + amount + ", ccy=" + ccy + ", destAcct=" + destAcct + ", id=" + id
                + ", srcAcct=" + srcAcct + ", ts=" + ts + "]";
    }


    
}
