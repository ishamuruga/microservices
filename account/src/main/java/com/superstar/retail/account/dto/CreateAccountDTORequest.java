package com.superstar.retail.account.dto;

import com.superstar.retail.account.entity.Account;

public class CreateAccountDTORequest {
    private Account act;

    public Account getAct() {
        return act;
    }

    public void setAct(Account act) {
        this.act = act;
    }
    
}
