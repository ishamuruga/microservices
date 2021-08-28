package com.superstar.order.orderservice;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderCommandController {
    private OrderCommandService orderCommandService;

    public OrderCommandController(OrderCommandService orderCommandService) {
        this.orderCommandService = orderCommandService;
    }

    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<String> createOrder(@RequestBody OrderCreateDTO orderCreateDTO){
        System.out.println("PS:createOrder Controller:================" + orderCreateDTO );
        return orderCommandService.createOrder(orderCreateDTO);
    }
}
