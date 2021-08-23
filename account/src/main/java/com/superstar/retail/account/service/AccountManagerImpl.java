package com.superstar.retail.account.service;

import javax.transaction.Transactional;

import com.superstar.retail.account.entity.Account;
import com.superstar.retail.account.exception.InSufficientBalance;
import com.superstar.retail.account.repo.AccountRepo;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.superstar.retail.account.aggregate.AccountActivatedEvent;
import com.superstar.retail.account.aggregate.CreateAccountCommand;

@Service
@Transactional
public class AccountManagerImpl implements AccountManager{

    private final CommandGateway commandGateway;

    @Autowired
    private AccountRepo repo;

    
    AccountManagerImpl(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    @Override
    public Account createAccount(Account acct) {
        repo.save(acct);
        System.out.println(acct);
        CompletableFuture<String>  future = commandGateway.send(new CreateAccountCommand(UUID.randomUUID().toString(),acct.getAccNbr(),acct.getBalance(),acct.getCcy()));
        return acct;
    }

    @Override
    public Account disableAccount(Account act) {
        act.setStatus("Disabled");
        repo.save(act);
        return act;
    }

    @Override
    public Account enableAccount(Account act) {
        act.setStatus("Enabled");
        repo.save(act);
        return act;
    }

    @Override
    public Account creditAccount(Account act, Double balance) {
        
        act.setBalance(act.getBalance() + balance);
        repo.save(act);

        return act;
    }

    @Override
    public Account debitAccount(Account act, Double balance) throws InSufficientBalance {
        if (act.getBalance() - balance > 0) {
            repo.save(act);
        } else {
            throw new InSufficientBalance("InSufficient Balance");
        }
    
        return act;
    }

    @EventHandler
    public void on(AccountActivatedEvent aae){
        System.out.println("### --> AccountActivatedEvent-" + aae.id);
    }


}

