package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.entity.Order;
import com.ecommerce.ecommerceapplication.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
   private OrderRepository orderRepository;

    public Order placeOrder (String cartId,BigDecimal discountPercentage){


        BigDecimal subTotal =orderRepository.subTotal(cartId);
        BigDecimal discountFraction = discountPercentage.divide(BigDecimal.valueOf(100));


        BigDecimal discount = subTotal.multiply(discountFraction);

        BigDecimal grandTotal = subTotal.subtract(discount);

        Order order = new Order();
        order.setOrderId(UUID.randomUUID());
        order.setDiscount(discount);
        order.setGrandTotal(grandTotal);
        order.setSubTotal(subTotal);
         return orderRepository.save(order);
    }

}
