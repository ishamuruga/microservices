package com.superstar.order.orderservice;

import java.util.concurrent.CompletableFuture;

public interface OrderCommandService { 
    public CompletableFuture<String> createOrder(OrderCreateDTO orderCreateDTO);
}
