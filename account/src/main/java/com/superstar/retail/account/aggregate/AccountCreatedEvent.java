package com.superstar.retail.account.aggregate;

public class AccountCreatedEvent extends BaseEvent<String> {

    public final double accountBalance;

    public final String currency;

    public final Integer actNbr;

    public AccountCreatedEvent(String id,Integer actNbr, double accountBalance, String currency) {
        super(id);
        this.actNbr = actNbr;
        this.accountBalance = accountBalance;
        this.currency = currency;
        System.out.println(id + "," + actNbr + ',' + accountBalance + "," + currency);
    }
}