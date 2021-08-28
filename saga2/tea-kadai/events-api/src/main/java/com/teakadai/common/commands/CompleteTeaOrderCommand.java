package com.teakadai.common.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CompleteTeaOrderCommand {
    @TargetAggregateIdentifier
    public final String orderId;

    public final String paymantId;

    public final String orderStatus;

    public final String user;

    public CompleteTeaOrderCommand(String orderId, String orderStatus,String user,String paymentId) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.user = user;
        this.paymantId = paymentId;
    }
}
