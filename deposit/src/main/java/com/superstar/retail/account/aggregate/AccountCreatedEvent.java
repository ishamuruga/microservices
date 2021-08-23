package com.superstar.retail.account.aggregate;

public class AccountCreatedEvent extends BaseEvent<Integer> {

    public final double accountBalance;

    public final String currency;

    public AccountCreatedEvent(Integer id, double accountBalance, String currency) {
        super(id);
        this.accountBalance = accountBalance;
        this.currency = currency;
    }
}