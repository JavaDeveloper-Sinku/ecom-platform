package com.example.orderservice.service;


import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }


    // Methods

    public Order createOrder(Order order){
        order.setStatus("PENDING");
        return orderRepository.save(order);

    }
    public List<Order> getAllOrders(){
        return orderRepository.findAll();

    }
    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }


}

