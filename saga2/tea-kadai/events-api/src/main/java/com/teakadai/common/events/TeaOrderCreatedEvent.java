package com.teakadai.common.events;

public class TeaOrderCreatedEvent {
	public final String orderId;
	 
	 public final Double cost;
	 
	 public final String orderStatus;

	 public final String user;

	 
 	 
	 public TeaOrderCreatedEvent(String orderID,Double cost,String status,String user) {
		this.orderId = orderID;
		this.cost = cost;
		this.orderStatus = status;
		this.user = user;
	 }
}
