package com.superstar.order.orderservice;

import java.math.BigDecimal;

import com.superstar.eventapi.command.CreateOrderCommand;
import com.superstar.eventapi.command.UpdateOrderStatusCommand;
import com.superstar.eventapi.event.OrderCreatedEvent;
import com.superstar.eventapi.event.OrderUpdatedEvent;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class OrderAggregate {
    @AggregateIdentifier
    private String orderId;

    private ItemType itemType;

    private BigDecimal price;

    private String currency;

    private OrderStatus orderStatus;

    public OrderAggregate() {
    }

    @CommandHandler
    public OrderAggregate(CreateOrderCommand createOrderCommand){
        System.out.println("PS:OrderAggregate 1Const:================" + createOrderCommand.currency);
        System.out.println("PS:OrderAggregate 2Const:================" + createOrderCommand.itemType);
        System.out.println("PS:OrderAggregate 3Const:================" + createOrderCommand.orderId);
        System.out.println("PS:OrderAggregate 4Const:================" + createOrderCommand.orderStatus);
        AggregateLifecycle.apply(new OrderCreatedEvent(createOrderCommand.orderId, createOrderCommand.itemType,
                createOrderCommand.price, createOrderCommand.currency, createOrderCommand.orderStatus));
    }

    @EventSourcingHandler
    protected void on(OrderCreatedEvent orderCreatedEvent){
        System.out.println("PS:OrderAggregate EventSourcingHandler ON-OrderCreatedEvent ");
        this.orderId = orderCreatedEvent.orderId;
        this.itemType = ItemType.valueOf(orderCreatedEvent.itemType);
        this.price = orderCreatedEvent.price;
        this.currency = orderCreatedEvent.currency;
        this.orderStatus = OrderStatus.valueOf(orderCreatedEvent.orderStatus);
    }

    @CommandHandler
    protected void on(UpdateOrderStatusCommand updateOrderStatusCommand){
        System.out.println("PS:OrderAggregate EventSourcingHandler ON-UpdateOrderStatusCommand");
        AggregateLifecycle.apply(new OrderUpdatedEvent(updateOrderStatusCommand.orderId, updateOrderStatusCommand.orderStatus));
    }

    @EventSourcingHandler
    protected void on(OrderUpdatedEvent orderUpdatedEvent){
        System.out.println("PS:OrderAggregate EventSourcingHandler ON-OrderUpdatedEvent");
        this.orderId = orderId;
        this.orderStatus = OrderStatus.valueOf(orderUpdatedEvent.orderStatus);
        System.out.println("PS:OrderAggregate EventSourcingHandler ON-OrderUpdatedEvent Completed");
    }
}
