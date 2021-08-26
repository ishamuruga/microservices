package com.superstar.retail.account.aggregate;

public class CreditAccountCommand extends BaseCommand<String> {

    public final double accountBalance;

    public final String currency;

    public final Integer actNbr;

    public CreditAccountCommand(String id, Integer actNbr, double accountBalance, String currency) {
        super(id);
        this.actNbr = actNbr;
        this.accountBalance = accountBalance;
        this.currency = currency;
    }
    
}
