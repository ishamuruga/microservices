package com.teakadai.menu.menuservice.aggregate;

import com.teakadai.common.commands.*;
import com.teakadai.common.events.*;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class TeaOrderAggregate {
    
    @AggregateIdentifier
    private String orderId;

    private Double price;

    private String orderStatus;

    private String user;

    public TeaOrderAggregate(){

    }

    @CommandHandler
    public TeaOrderAggregate(CreateTeaOrderCommand createTeaOrderCommand){
        this.orderId = createTeaOrderCommand.orderId;
        this.price =  createTeaOrderCommand.cost;
        this.orderStatus = createTeaOrderCommand.orderStatus;
        this.user = createTeaOrderCommand.user;
        AggregateLifecycle.apply(
            new TeaOrderCreatedEvent(
                createTeaOrderCommand.orderId, 
                createTeaOrderCommand.cost, 
                createTeaOrderCommand.orderStatus,
                createTeaOrderCommand.user
                )
        );
    }

    @EventSourcingHandler
    protected void on(TeaOrderCreatedEvent teaOrderCreatedEvent){
        this.orderId = teaOrderCreatedEvent.orderId;
        this.price =  teaOrderCreatedEvent.cost;
        this.orderStatus = teaOrderCreatedEvent.orderStatus;
        this.user = teaOrderCreatedEvent.user;        
    }

    @CommandHandler
    protected void on(CompleteTeaOrderCommand completeTeaOrderCommand){

        AggregateLifecycle.apply(
            new OrderCompletedEvent(
                completeTeaOrderCommand.orderId, 
                completeTeaOrderCommand.orderStatus,
                completeTeaOrderCommand.user,
                completeTeaOrderCommand.paymantId
                )
        );
    }

    @EventSourcingHandler
    protected void on(OrderCompletedEvent orderCompletedEvent){
        this.orderId = orderCompletedEvent.orderId;
        this.orderStatus = orderCompletedEvent.orderStatus;
        this.user = orderCompletedEvent.user;        
    }
}
