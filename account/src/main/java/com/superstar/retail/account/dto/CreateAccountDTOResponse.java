package com.superstar.retail.account.dto;

import com.superstar.retail.account.entity.Account;

public class CreateAccountDTOResponse {
    private int actId;

    private Boolean status;

    public int getActId() {
        return actId;
    }

    public void setActId(int actId) {
        this.actId = actId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

        
}
