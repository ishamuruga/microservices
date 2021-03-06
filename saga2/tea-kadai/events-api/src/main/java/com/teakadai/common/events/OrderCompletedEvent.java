package com.teakadai.common.events;

public class OrderCompletedEvent {
    public final String orderId;

    public final String orderStatus;

    public final String user;

    public final String paymentId;

    public final String txnRefNum;

    public OrderCompletedEvent(String orderId, String orderStatus,String user,String paymantId,String txnRefNum) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.user = user;
        this.paymentId = paymantId;
        this.txnRefNum = txnRefNum;
    }
}

