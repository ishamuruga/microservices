package com.superstar.retail.account.aggregate;

public class AccountActivatedEvent  extends BaseEvent<String> {

    public final String status;

    public Integer actNbr;

    public AccountActivatedEvent(String id, Integer actNbr, String status) {
        super(id);
        this.status = status;
        this.actNbr = actNbr;
    }
}