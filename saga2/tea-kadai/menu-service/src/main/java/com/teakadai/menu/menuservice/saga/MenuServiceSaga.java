package com.teakadai.menu.menuservice.saga;

import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;

import com.teakadai.common.commands.*;
import com.teakadai.common.events.*;
import com.teakadai.menu.menuservice.entity.OrderTea;
import com.teakadai.menu.menuservice.repo.OrderTeaRepo;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
public class MenuServiceSaga {

    @Inject
    private transient CommandGateway commandGateway;

    //@Autowired
    //private OrderTeaRepo repo;
    
    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(TeaOrderCreatedEvent orderCreatedEvent){
        
        String paymentId = UUID.randomUUID().toString();
        System.out.println("Saga Creaed.." + paymentId);

        //associate Saga
        SagaLifecycle.associateWith("paymentId",paymentId);

        System.out.println("## PS 1 - Saga Start: TeaOrderCreatedEvent");
        System.out.println("## PS 2 - Saga Start: TeaOrderCreatedEvent-"+paymentId);
        System.out.println("## PS 3 - Saga Start: TeaOrderCreatedEvent-"+orderCreatedEvent.orderId);
        System.out.println("## PS 4 - Saga Start: TeaOrderCreatedEvent-"+orderCreatedEvent.cost);
        System.out.println("## PS 5 - Saga Start: TeaOrderCreatedEvent-"+orderCreatedEvent.user);
        System.out.println("## PS 6 - Saga Start: TeaOrderCreatedEvent-"+orderCreatedEvent.orderStatus);

        //send the commands  
        commandGateway.send(
            new TeaOrderCreateInvoiceCommand(
                paymentId,
                orderCreatedEvent.orderId,
                orderCreatedEvent.cost,
                orderCreatedEvent.user,
                orderCreatedEvent.orderStatus
            )
        );
    }

    @SagaEventHandler(associationProperty = "paymentId")
    public void handle(OrderCompletedEvent orderCompletedEvent) {
        System.out.println("## PS 1 - Saga End: OrderCompletedEvent");

        System.out.println("## PS 2 - Saga End: OrderCompletedEvent" + orderCompletedEvent.txnRefNum);
        System.out.println("## PS 3 - Saga End: OrderCompletedEvent" + orderCompletedEvent.orderId);

        

        //Optional<OrderTea> orderTea = repo.findById(orderCompletedEvent.orderId);
        //OrderTea oTea = orderTea.get();
        //oTea.setIsSucess(true);
        //oTea.setTxnRefNumber(orderCompletedEvent.txnRefNum);

        //repo.save(oTea);
        System.out.println("## PS 4 - Saga End: OrderCompletedEvent DB UPDATED");

        SagaLifecycle.end();        
    }

    @SagaEventHandler(associationProperty = "paymentId")
    public void handle(OrderNotCompletedEvent orderCompletedEvent) {
        System.out.println("## PS 1 - Saga End: OrderNotCompletedEvent");
        System.out.println("## PS 2 - Saga End: OrderNotCompletedEvent" + orderCompletedEvent.orderId);
        
        //Optional<OrderTea> orderTea = repo.findById(orderCompletedEvent.orderId);
        //OrderTea oTea = orderTea.get();
        //oTea.setIsSucess(false);
        //oTea.setTxnRefNumber("NONE");

        //repo.save(oTea);
        System.out.println("## PS 3 - Saga End: OrderNotCompletedEvent DB UPDATED");
        SagaLifecycle.end();
    }

    
}
