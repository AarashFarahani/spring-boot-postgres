package com.sb.txpostgres.service;

import com.sb.txpostgres.entity.Order;
import com.sb.txpostgres.entity.Product;
import com.sb.txpostgres.repository.OrderRepository;
import com.sb.txpostgres.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class OrderService {
    @Autowired private OrderRepository orderRepository;
    @Autowired private ProductRepository productRepository;

    @Transactional
    public void doOrder(Order order)
            throws Exception {
        Product product = this.productRepository
                .findById(order.getProductId())
                .orElseThrow(() -> new Exception("Error"));
        product.setNumber(product.getNumber() - 1);
        this.productRepository.save(product);

        order.setDate(new Date(System.currentTimeMillis()));
        this.orderRepository.save(order);
    }
}
