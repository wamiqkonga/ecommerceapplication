package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.entity.Cart;
import com.ecommerce.ecommerceapplication.entity.Transaction;
import com.ecommerce.ecommerceapplication.enums.Status;
import com.ecommerce.ecommerceapplication.model.TransactionRequest;
import com.ecommerce.ecommerceapplication.repository.CartRepository;
import com.ecommerce.ecommerceapplication.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public Transaction paid(TransactionRequest transactionRequest) {

        Transaction transaction = new Transaction();
        Cart cart = new Cart();
        transaction.setOrderId(transactionRequest.getOrderId());
        transaction.setTransId(transactionRequest.getTransId());
        transaction.setCreatedDate(Calendar.getInstance());
        transaction.setStatus(Status.PAID);

        if (transactionRepository.equals(Status.PAID)) {

        }
        else {
            return null;
        }




     return    transactionRepository.save(transaction);
    }
}
