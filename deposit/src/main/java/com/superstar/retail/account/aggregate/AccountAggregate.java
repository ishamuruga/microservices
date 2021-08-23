package com.superstar.retail.account.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class AccountAggregate {

    @AggregateIdentifier
    private int accNbr;

    private String customerName;

    private Double balance;

    private String type;

    private String status;

    private String ccy;

    public AccountAggregate(){
        System.out.println("## Default Acccount Aggregate Constructor");
    }


    // @CommandHandler
    // public AccountAggregate(CreateAccountCommand createAccountCommand){
    //     System.out.println("### Command CreateAccountCommand  Created");
    //     AggregateLifecycle.apply(new AccountCreatedEvent(createAccountCommand.id, createAccountCommand.accountBalance, createAccountCommand.currency));
    // }

    // @EventSourcingHandler
    // protected void on(AccountCreatedEvent accountCreatedEvent){
    //     System.out.println("### Event AccountCreatedEvent  Processed");
    //     this.accNbr = accountCreatedEvent.id;
    //     this.balance = accountCreatedEvent.accountBalance;
    //     this.ccy = accountCreatedEvent.currency;
    //     this.status = "CREATED";

    //     AggregateLifecycle.apply(new AccountActivatedEvent(accountCreatedEvent.id,this.accNbr, "ACTIVATED"));
    // }

    @EventSourcingHandler
    protected void on(AccountActivatedEvent accountActivatedEvent){
        System.out.println("## accountActivatedEvent Created");
        this.status = String.valueOf(accountActivatedEvent.status);
    }

    public int getAccNbr() {
        return accNbr;
    }

    public void setAccNbr(int accNbr) {
        this.accNbr = accNbr;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }    

    

}
