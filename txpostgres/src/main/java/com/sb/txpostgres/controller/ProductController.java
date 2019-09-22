package com.sb.txpostgres.controller;

import com.sb.txpostgres.entity.Product;
import com.sb.txpostgres.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {
        this.repository.save(product);
        return ResponseEntity.ok().body(product.getId());
    }
}
