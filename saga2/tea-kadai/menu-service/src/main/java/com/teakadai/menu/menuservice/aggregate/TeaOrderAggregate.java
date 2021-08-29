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

        System.out.println("## MS - Aggregate: CreateTeaOrderCommand");

        //this.orderId = createTeaOrderCommand.orderId;
        //this.price =  createTeaOrderCommand.cost;
        //this.orderStatus = createTeaOrderCommand.orderStatus;
        //this.user = createTeaOrderCommand.user;
        System.out.println("## 1 MS - Aggregate: CreateTeaOrderCommand - Cons-" + createTeaOrderCommand.orderId);
        System.out.println("## 2 MS - Aggregate: CreateTeaOrderCommand - Cons-" + createTeaOrderCommand.cost);
        System.out.println("## 3 MS - Aggregate: CreateTeaOrderCommand - Cons-" + createTeaOrderCommand.orderStatus);
        System.out.println("## 4 MS - Aggregate: CreateTeaOrderCommand - Cons-" + createTeaOrderCommand.user);

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
         System.out.println("## MS - Aggregate: TeaOrderCreatedEvent");
         this.orderId = teaOrderCreatedEvent.orderId;
         this.price =  teaOrderCreatedEvent.cost;
         this.orderStatus = teaOrderCreatedEvent.orderStatus;
         this.user = teaOrderCreatedEvent.user;        
     }

     @CommandHandler
     protected void on(CompleteTeaOrderCommand completeTeaOrderCommand){
         System.out.println("## MS 1 - Aggregate: CompleteTeaOrderCommand");
         System.out.println("## MS 2 - Aggregate: CompleteTeaOrderCommand-"+completeTeaOrderCommand.orderId);
         System.out.println("## MS 3 - Aggregate: CompleteTeaOrderCommand-"+completeTeaOrderCommand.orderStatus);
         System.out.println("## MS 4 - Aggregate: CompleteTeaOrderCommand-"+completeTeaOrderCommand.user);
         System.out.println("## MS 5 - Aggregate: CompleteTeaOrderCommand-"+completeTeaOrderCommand.paymantId);
         AggregateLifecycle.apply(
             new OrderCompletedEvent(
                 completeTeaOrderCommand.orderId, 
                 completeTeaOrderCommand.orderStatus,
                 completeTeaOrderCommand.user,
                 completeTeaOrderCommand.paymantId,
                 ""
                 )
         );
     }

      @EventSourcingHandler
      protected void on(OrderCompletedEvent orderCompletedEvent){
          System.out.println("## MS 1 - Aggregate: OrderCompletedEvent");
          this.orderId = orderCompletedEvent.orderId;
          this.orderStatus = orderCompletedEvent.orderStatus;
          this.user = orderCompletedEvent.user;        
      }
}
