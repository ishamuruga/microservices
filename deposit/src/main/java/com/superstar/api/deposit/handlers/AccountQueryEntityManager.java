package com.superstar.api.deposit.handlers;


import com.superstar.api.deposit.entity.AccountQuery;
import com.superstar.api.deposit.repo.AccountQueryRepo;
import com.superstar.retail.account.aggregate.AccountActivatedEvent;
import com.superstar.retail.account.aggregate.AccountAggregate;
import com.superstar.retail.account.aggregate.BaseEvent;
import com.superstar.retail.account.aggregate.CreditAccountEvent;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AccountQueryEntityManager {
    
    @Autowired
    private AccountQueryRepo accountRepository;

    @Autowired
    @Qualifier("accountAggregateEventSourcingRepository")
    private EventSourcingRepository<AccountAggregate> accountAggregateEventSourcingRepository;

    @EventSourcingHandler
    public void on(AccountActivatedEvent event){
        System.out.println("$$$$$$ Event:-" + event.getClass().getName());
        System.out.println("===========================================AccountActivatedEvent");

        System.out.println("$$$$$$ Event:-" + event.id);
        System.out.println("$$$$$$ Event:-" + event.status);
        System.out.println("$$$$$$ Event:-" + event.actNbr);

        AccountQuery actQuery = new AccountQuery();
        actQuery.setBalance(100d);
        actQuery.setAcct(event.actNbr);
        actQuery.setId(event.id);
        //actQuery.setBalance(balance);
        actQuery.setStatus(event.status);

        accountRepository.save(actQuery);

        
    }

    @EventSourcingHandler
    public void on(CreditAccountEvent event){
        System.out.println("===========================================CreditAccountEvent");
        System.out.println("$$$$$$ Event:-" + event.getClass().getName());

        System.out.println("$$$$$$ Event:-" + event.id);
        System.out.println("$$$$$$ Event:-" + event.actNbr);

        AccountQuery actQuery = new AccountQuery();
        actQuery.setBalance(event.accountBalance);
        actQuery.setAcct(event.actNbr);
        actQuery.setStatus("Deposited");
        actQuery.setId(event.id);
        accountRepository.save(actQuery);

        
    }



}
