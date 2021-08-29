package com.teakadai.payment.paymentservice;

import java.util.UUID;

import com.teakadai.common.commands.CompleteTeaOrderCommand;
import com.teakadai.common.commands.TeaOrderCreateInvoiceCommand;
import com.teakadai.common.events.OrderCompletedEvent;
import com.teakadai.common.events.OrderNotCompletedEvent;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class PaymentAggregate {
    @AggregateIdentifier
    private String paymentId;

    private String orderId;

    private String status;

    private String user;

    @CommandHandler
    public PaymentAggregate(TeaOrderCreateInvoiceCommand teaOrderCreateInvoiceCommand) {

        System.out.println("## PS 1 - Aggregate: TeaOrderCreateInvoiceCommand");
        System.out.println("## PS 2 - Aggregate: TeaOrderCreateInvoiceCommand-" + teaOrderCreateInvoiceCommand.orderId);
        System.out.println("## PS 3 - Aggregate: TeaOrderCreateInvoiceCommand-" + teaOrderCreateInvoiceCommand.status);
        System.out.println("## PS 4 - Aggregate: TeaOrderCreateInvoiceCommand-" + teaOrderCreateInvoiceCommand.user);
        System.out
                .println("## PS 5 - Aggregate: TeaOrderCreateInvoiceCommand-" + teaOrderCreateInvoiceCommand.paymentId);

        //this.paymentId = teaOrderCreateInvoiceCommand.paymentId;
        //this.orderId = teaOrderCreateInvoiceCommand.orderId;
        //this.status = teaOrderCreateInvoiceCommand.status;
        //this.user = teaOrderCreateInvoiceCommand.user;

        if (teaOrderCreateInvoiceCommand.user.equalsIgnoreCase("Shivan")) {
            System.out.println("## PS 6 - Aggregate: TeaOrderCreateInvoiceCommand-SUCESS ##");
            // On Sucess
            AggregateLifecycle.apply(new OrderCompletedEvent(teaOrderCreateInvoiceCommand.orderId,
                    teaOrderCreateInvoiceCommand.status, teaOrderCreateInvoiceCommand.user,
                    teaOrderCreateInvoiceCommand.paymentId, "ORDR".concat(UUID.randomUUID().toString())));
        } else {
            System.out.println("## PS 6 - Aggregate: TeaOrderCreateInvoiceCommand-FAILURE **");
            AggregateLifecycle.apply(new OrderNotCompletedEvent(teaOrderCreateInvoiceCommand.orderId,
                    teaOrderCreateInvoiceCommand.status, teaOrderCreateInvoiceCommand.user,
                    teaOrderCreateInvoiceCommand.paymentId));
        }

    }

    @EventSourcingHandler
    protected void on(OrderCompletedEvent invoiceCreatedEvent) {
        System.out.println("## PS OrderCompletedEvent  - ON");
        this.paymentId = invoiceCreatedEvent.paymentId;
        this.orderId = invoiceCreatedEvent.orderId;
        this.status = invoiceCreatedEvent.orderStatus;
        this.user = invoiceCreatedEvent.user;

    }

    @EventSourcingHandler
    protected void on(OrderNotCompletedEvent invoiceNotCreatedEvent) {
        System.out.println("## PS OrderNotCompletedEvent  - ON");
        this.paymentId = invoiceNotCreatedEvent.paymentId;
        this.orderId = invoiceNotCreatedEvent.orderId;
        this.status = invoiceNotCreatedEvent.orderStatus;
        this.user = invoiceNotCreatedEvent.user;
    }


}
