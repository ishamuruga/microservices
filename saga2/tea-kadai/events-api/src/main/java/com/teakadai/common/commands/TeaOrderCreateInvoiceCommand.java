package com.teakadai.common.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class TeaOrderCreateInvoiceCommand {
	@TargetAggregateIdentifier
	public final String paymentId;

	public final String orderId;

	public Double cost;

	public String user;

	public String status;

	public TeaOrderCreateInvoiceCommand(String paymentId, String orderId,Double cost,String user,String status) {
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.user = user;
		this.cost = cost;
		this.status = status;
	}
}
