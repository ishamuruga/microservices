package com.teakadai.common.events;

public class OrderNotCompletedEvent {
    public final String orderId;

    public final String orderStatus;

    public final String user;

    public final String paymentId;

    public OrderNotCompletedEvent(String orderId, String orderStatus,String user,String paymantId) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.user = user;
        this.paymentId = paymantId;
    }
}

