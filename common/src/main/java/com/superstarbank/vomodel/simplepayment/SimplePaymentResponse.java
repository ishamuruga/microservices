package com.superstarbank.vomodel.simplepayment;

import com.superstarbank.vomodel.BaseVo;

public class SimplePaymentResponse  extends BaseVo  {
    private SimplePaymentRequest sPayRequest;

    private String txnRefNumber;

    private Boolean status;

    public SimplePaymentRequest getsPayRequest() {
        return sPayRequest;
    }

    public void setsPayRequest(SimplePaymentRequest sPayRequest) {
        this.sPayRequest = sPayRequest;
    }

    public String getTxnRefNumber() {
        return txnRefNumber;
    }

    public void setTxnRefNumber(String txnRefNumber) {
        this.txnRefNumber = txnRefNumber;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SimplePaymentResponse [sPayRequest=" + sPayRequest + ", status=" + status + ", txnRefNumber="
                + txnRefNumber + "]";
    }

    
}
