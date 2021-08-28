package com.teakadai.menu.menuservice.controller;

import com.teakadai.menu.menuservice.entity.OrderTea;
import com.teakadai.menu.menuservice.service.OrderTeaManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TeaOrderController {
    
    @Autowired
    private OrderTeaManager service;

    @PostMapping(value = "/order",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderTea> doOrderTea(@RequestBody  OrderTea orderTea) throws Exception{
        service.doTeaOrder(orderTea);

        return new ResponseEntity<OrderTea>(orderTea,HttpStatus.OK);
    }
}
