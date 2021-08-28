package com.teakadai.common.events;

public class OrderCompletedEvent {
    public final String orderId;

    public final String orderStatus;

    public final String user;

    public final String paymantId;

    public OrderCompletedEvent(String orderId, String orderStatus,String user,String paymantId) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.user = user;
        this.paymantId = paymantId;
    }
}

