package com.superstar.retail.account.dto;

import com.superstar.retail.account.entity.Account;

public class CreditDebitAccountRequest {
    private Account act;

    private Double amount;

    private Boolean isCredit;

    public Account getAct() {
        return act;
    }

    public void setAct(Account act) {
        this.act = act;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getIsCredit() {
        return isCredit;
    }

    public void setIsCredit(Boolean isCredit) {
        this.isCredit = isCredit;
    }

    
}
