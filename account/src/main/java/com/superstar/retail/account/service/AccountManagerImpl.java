package com.superstar.retail.account.service;

import javax.transaction.Transactional;

import com.superstar.retail.account.entity.Account;
import com.superstar.retail.account.exception.InSufficientBalance;
import com.superstar.retail.account.repo.AccountRepo;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.superstar.retail.account.aggregate.AccountActivatedEvent;
import com.superstar.retail.account.aggregate.CreateAccountCommand;
import com.superstar.retail.account.aggregate.CreditAccountCommand;

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
    public Account creditAccount(Account acct, Double balance) throws IllegalAccessException {
        

        Optional<Account> act = repo.findById(acct.getAccNbr());

        if (act.get() != null){
            acct.setBalance(act.get().getBalance());
        } else {
            throw new IllegalAccessException("No Account Found");
        }

        

        System.out.println("1=====" + acct);
        System.out.println("2=====" + balance);

        String uuid = UUID.randomUUID().toString();

        System.out.println("3=====" + uuid);

        acct.setBalance(acct.getBalance() + balance);
        repo.save(acct);
        System.out.println(acct);
        CompletableFuture<String>  future = commandGateway.send(
                new CreditAccountCommand(uuid,
                        acct.getAccNbr(),
                        acct.getBalance(),
                        acct.getCcy()));
        
        return acct;
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

    // @EventHandler
    // public void on(AccountActivatedEvent aae){
    //     System.out.println("### --> AccountActivatedEvent-" + aae.id);
    // }


}

