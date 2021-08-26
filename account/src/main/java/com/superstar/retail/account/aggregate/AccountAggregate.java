package com.superstar.retail.account.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class AccountAggregate {

    @AggregateIdentifier
    private String id;

    private int accNbr;

    private String customerName;

    private Double balance;

    private String type;

    private String status;

    private String ccy;

    @CommandHandler
    public AccountAggregate(CreateAccountCommand createAccountCommand) {
        System.out.println("### Command CreateAccountCommand  Created");
        AggregateLifecycle.apply(new AccountCreatedEvent(createAccountCommand.id, createAccountCommand.actNbr,
                createAccountCommand.accountBalance, createAccountCommand.currency));
    }

    @CommandHandler
    public AccountAggregate(CreditAccountCommand creditAccountCommand) {
        System.out.println("###2- Command CreditAccountCommand  Created");
        System.out.println("###3- " + creditAccountCommand.id);
        System.out.println("###4- " + creditAccountCommand.accountBalance);
        System.out.println("###5- " + creditAccountCommand.currency);
        System.out.println("###6- " + creditAccountCommand.actNbr);

        this.id = creditAccountCommand.id;

        AggregateLifecycle.apply(new CreditAccountEvent(creditAccountCommand.id, creditAccountCommand.actNbr,
            creditAccountCommand.accountBalance, creditAccountCommand.currency));
    }

    @EventSourcingHandler
    protected void on(AccountCreatedEvent accountCreatedEvent) {
        
        this.id = accountCreatedEvent.id;
        this.accNbr = accountCreatedEvent.actNbr;
        this.balance = accountCreatedEvent.accountBalance;
        this.ccy = accountCreatedEvent.currency;
        this.status = "CREATED";

        System.out.println("### Event AccountCreatedEvent  Processed..." + this.id);

        AggregateLifecycle.apply(new AccountActivatedEvent(this.id, this.accNbr, "ACTIVATED"));
    }



    
    // @EventSourcingHandler
    // protected void on(AccountActivatedEvent accountActivatedEvent){
    // System.out.println("## on Account Activated Event");
    // this.status = String.valueOf(accountActivatedEvent.status);
    // }

}
