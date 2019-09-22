package com.sb.txpostgres.controller;

import com.sb.txpostgres.entity.Order;
import com.sb.txpostgres.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Order order) {
        try {
            this.orderService.doOrder(order);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
