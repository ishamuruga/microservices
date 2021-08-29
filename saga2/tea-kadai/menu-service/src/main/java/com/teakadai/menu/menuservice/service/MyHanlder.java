package com.teakadai.menu.menuservice.service;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.teakadai.menu.menuservice.repo.OrderTeaRepo;
import com.teakadai.menu.menuservice.entity.OrderTea;
import java.util.Optional;

import com.teakadai.common.events.*;

@Component
public class MyHanlder {

    @Autowired
    private OrderTeaRepo repo;

    @EventSourcingHandler
    public void on(OrderCompletedEvent e) {
        
        System.out.println(" ### NEW UPDATE......");
        Optional<OrderTea> orderTea = repo.findById(e.orderId);
        OrderTea oTea = orderTea.get();
        oTea.setIsSucess(true);
        oTea.setTxnRefNumber(e.txnRefNum);

        repo.save(oTea);
    }

    @EventSourcingHandler
    public void on(OrderNotCompletedEvent e) {
        
        System.out.println(" ### NEW UPDATE......Failure");
         String orderId  = e.orderId;
         //System.out.println("==========================================2");
         Optional<OrderTea> orderTea = repo.findById(orderId);
         //System.out.println("==========================================3");
         OrderTea oTea = orderTea.get();
         //System.out.println("==========================================4");
         oTea.setIsSucess(false);
         //System.out.println("==========================================5");
         oTea.setTxnRefNumber("NONE");
         //System.out.println("==========================================6");
 
         repo.save(oTea);
    }
}
