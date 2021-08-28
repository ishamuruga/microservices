package com.teakadai.menu.menuservice.saga;

import java.util.UUID;

import javax.inject.Inject;

import com.teakadai.common.commands.*;
import com.teakadai.common.events.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

@Saga
public class MenuServiceSaga {

    @Inject
    private transient CommandGateway commandGateway;
    
    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(TeaOrderCreatedEvent orderCreatedEvent){
        
        String paymentId = UUID.randomUUID().toString();
        System.out.println("Saga Creaed.." + paymentId);

        //associate Saga
        SagaLifecycle.associateWith("paymentId",paymentId);


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

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCompletedEvent orderCompletedEvent) {
        SagaLifecycle.end();
    }
}
