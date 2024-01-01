package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.entity.Cart;
import com.ecommerce.ecommerceapplication.entity.Order;
import com.ecommerce.ecommerceapplication.entity.Transaction;
import com.ecommerce.ecommerceapplication.enums.Status;
import com.ecommerce.ecommerceapplication.model.TransactionRequest;
import com.ecommerce.ecommerceapplication.repository.CartRepository;
import com.ecommerce.ecommerceapplication.repository.OrderRepository;
import com.ecommerce.ecommerceapplication.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CartRepository cartRepository ;
    @Autowired
    CartService cartService;

    public Transaction paid(TransactionRequest transactionRequest) {

        Transaction transaction = new Transaction();
        transaction.setOrderId(transactionRequest.getOrderId());
        transaction.setTransId(transactionRequest.getTransId());
        transaction.setCreatedDate(Calendar.getInstance());
        transaction.setStatus(Status.PAID);

        transaction = transactionRepository.save(transaction);

        if (transaction.getStatus() == Status.PAID) {
            
            UUID orderId = transactionRequest.getOrderId();
            Order order = orderRepository.findByOrderId(orderId);
//            System.out.println("inside..." + orderId);
//            System.out.println("cartId " + order.getCartId());
            updateCartStatus(order.getCartId(), Status.DELETED);
        }


        return transaction;
    }

    @Transactional
    public void updateCartStatus(String cartId, Status status) {
        Cart cart = cartRepository.findByCartId(cartId);
        System.out.println("-----" + cartId);
        if (cart != null) {
            cart.setStatus(status);
            cartRepository.save(cart);
        }
    }

}

