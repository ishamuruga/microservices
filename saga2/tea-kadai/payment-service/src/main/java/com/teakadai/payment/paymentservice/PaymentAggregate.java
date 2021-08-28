package com.teakadai.payment.paymentservice;

import com.teakadai.common.commands.CompleteTeaOrderCommand;
import com.teakadai.common.commands.TeaOrderCreateInvoiceCommand;
import com.teakadai.common.events.OrderCompletedEvent;

import org.axonframework.commandhandling.CommandHandler;
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
    public PaymentAggregate(TeaOrderCreateInvoiceCommand teaOrderCreateInvoiceCommand){
        // On Sucess
        AggregateLifecycle.apply(
            new OrderCompletedEvent(
                teaOrderCreateInvoiceCommand.orderId,
                teaOrderCreateInvoiceCommand.status,
                teaOrderCreateInvoiceCommand.user,
                teaOrderCreateInvoiceCommand.paymentId 
            )
        );
    }
}
