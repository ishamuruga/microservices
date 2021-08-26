package com.superstar.retail.account.dto;

import com.superstar.retail.account.entity.Account;

public class CreditDebitAccountResponse {
    private Account act;

    private Boolean status;

    private String txnRefNumber;

    public Account getAct() {
        return act;
    }

    public String getTxnRefNumber() {
        return txnRefNumber;
    }

    public void setTxnRefNumber(String txnRefNumber) {
        this.txnRefNumber = txnRefNumber;
    }

    public void setAct(Account act) {
        this.act = act;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
