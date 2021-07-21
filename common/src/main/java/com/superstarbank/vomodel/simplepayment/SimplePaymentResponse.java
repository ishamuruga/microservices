package com.superstarbank.vomodel.simplepayment;

import java.math.BigDecimal;

import com.superstarbank.vomodel.BaseVo;

public class SimplePaymentResponse  extends BaseVo  {
    private SimplePaymentRequest sPayRequest;

    private String txnRefNumber;

    private Boolean status;

    private BigDecimal amount;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SimplePaymentResponse [amount=" + amount + ", sPayRequest=" + sPayRequest + ", status=" + status
                + ", txnRefNumber=" + txnRefNumber + "]";
    }


    
}
