package com.superstar.api.deposit.service;

import com.superstar.retail.account.aggregate.AccountCreatedEvent;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MyEventHandler {
    
    // @EventHandler
    // public void handle(AccountCreatedEvent event) {
    //     System.out.println("## IN NEW EVENT HNDLER CLASS");
    // }

}
