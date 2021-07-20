package com.superstarbank.vomodel.simplepayment;

import com.superstarbank.vomodel.BaseVo;

public class SimplePaymentRequest extends BaseVo {
    private int id;

    private String srcAcct;

    private String destAcct;

    private int amount;

    private String ccy;

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

    @Override
    public String toString() {
        return "SimplePaymentRequest [amount=" + amount + ", ccy=" + ccy + ", destAcct=" + destAcct + ", id=" + id
                + ", srcAcct=" + srcAcct + "]";
    }

    public SimplePaymentRequest(int id, String srcAcct, String destAcct, int amount, String ccy) {
        this.id = id;
        this.srcAcct = srcAcct;
        this.destAcct = destAcct;
        this.amount = amount;
        this.ccy = ccy;
    }


    
}
