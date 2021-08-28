package com.teakadai.common.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateTeaOrderCommand {
	 @TargetAggregateIdentifier
	 public final String orderId;
	 
	 public final Double cost;
	 
	 public final String orderStatus;

	 public final String user;
	 	 
	 public CreateTeaOrderCommand(String orderID,Double cost,String status,String user) {
		this.orderId = orderID;
		this.cost = cost;
		this.orderStatus = status;
		this.user = user;
	 }
	 
}
