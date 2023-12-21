package com.ecommerce.ecommerceapplication.controller;

import com.ecommerce.ecommerceapplication.entity.Order;
import com.ecommerce.ecommerceapplication.model.OrderRequest;
import com.ecommerce.ecommerceapplication.model.OrderResponse;
import com.ecommerce.ecommerceapplication.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;


    @PostMapping("/placeOrder")
    public Order placeorder (@RequestParam String cartId, @RequestParam BigDecimal discount){
        return orderService.placeOrder(cartId,discount);
    }
}
