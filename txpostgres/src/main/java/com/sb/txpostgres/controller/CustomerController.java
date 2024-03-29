package com.sb.txpostgres.controller;

import com.sb.txpostgres.entity.Customer;
import com.sb.txpostgres.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired private CustomerRepository repository;

    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody Customer customer) {
        this.repository.save(customer);
        return ResponseEntity.ok().body(customer.getId());
    }
}
