package com.superstar.retail.account.aggregate;

public class CreateAccountCommand extends BaseCommand<Integer> {

    public final double accountBalance;

    public final String currency;

    public CreateAccountCommand(Integer id, double accountBalance, String currency) {
        super(id);
        this.accountBalance = accountBalance;
        this.currency = currency;
    }
    
}
