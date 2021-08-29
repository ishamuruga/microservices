package com.teakadai.menu.menuservice.service;

import com.teakadai.common.commands.CreateTeaOrderCommand;
import com.teakadai.menu.menuservice.entity.OrderTea;
import com.teakadai.menu.menuservice.repo.OrderTeaRepo;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * impl:-CreateTeaOrderCommand
 *    Agg:- TeamOrderCreatedEvent
 */

@Service
public class OrderTeaManagerImpl implements OrderTeaManager{

    @Autowired
    private OrderTeaRepo repo;
    
    private final CommandGateway commandGateway;

    public OrderTeaManagerImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    } 
    
    
    @Override
    public OrderTea doTeaOrder(OrderTea oTea) throws Exception {
        

        String orderid = UUID.randomUUID().toString();
        oTea.setId(orderid);
        repo.save(oTea);

        Double cost = oTea.getCount()*60d;

        System.out.println("## MS - Service UPD:" + oTea);
        
        CompletableFuture<String> fut = commandGateway.send(
                new CreateTeaOrderCommand(orderid,cost,"Created",oTea.getUserid()));

        //oTea.setTxnRefNumber(fut.get().toLowerCase());

        return oTea;
    }
    
}
