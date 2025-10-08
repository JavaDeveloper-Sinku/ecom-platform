package com.example.orderservice.service;


import com.example.orderservice.client.ProductClient;
import com.example.orderservice.dto.ProductResponse;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {


    private OrderRepository orderRepository;
    private ProductClient productClient;

    //Constructor
    public OrderService(OrderRepository orderRepository,ProductClient productClient){
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    public ProductResponse getProductByIdUsingFeign(Long productId){
        return productClient.getProductById(productId);
    }

    //Just testing service
   public void testFeignCall(Long productId){
       ProductResponse product = productClient.getProductById(productId);
       System.out.println("Product fetched via Feign: "+ product.getName());
   }

   public Order placeOrder(Long productId, int quantity){

        ProductResponse productResponse = productClient.getProductById(productId);

        if (productResponse == null || productResponse.getStock() == null){
            throw new RuntimeException("Product not found!");

        }

        if (productResponse.getStock() <= quantity){
            throw new RuntimeException("Product out of stock!");

        }

        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setStatus("Confirmed");

        Order saveOrder = orderRepository.save(order);

       System.out.println("Order placed successfully for "+ productResponse.getName());
       return saveOrder;
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

