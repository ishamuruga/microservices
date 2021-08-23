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
    public AccountAggregate(CreateAccountCommand createAccountCommand){
        System.out.println("### Command CreateAccountCommand  Created");
        AggregateLifecycle.apply(
                            new AccountCreatedEvent(
                                createAccountCommand.id, 
                                createAccountCommand.actNbr, 
                                createAccountCommand.accountBalance,
                                createAccountCommand.currency)
                            );
    }

      @EventSourcingHandler
      protected void on(AccountCreatedEvent accountCreatedEvent){
          System.out.println("### Event AccountCreatedEvent  Processed");
          this.id = accountCreatedEvent.id;
          this.accNbr = accountCreatedEvent.actNbr;
          this.balance = accountCreatedEvent.accountBalance;
          this.ccy = accountCreatedEvent.currency;
          this.status = "CREATED";

          AggregateLifecycle.apply(new AccountActivatedEvent(this.id,this.accNbr, "ACTIVATED"));
      }

     @EventSourcingHandler
     protected void on(AccountActivatedEvent accountActivatedEvent){
        System.out.println("## on Account Activated Event");
        this.status = String.valueOf(accountActivatedEvent.status);
     }    


}
