package com.ecommerce.ecommerceapplication.controller;

import com.ecommerce.ecommerceapplication.entity.Transaction;
import com.ecommerce.ecommerceapplication.model.TransactionRequest;
import com.ecommerce.ecommerceapplication.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/payment")
    public Transaction payment(@RequestBody TransactionRequest transactionRequest){
        return transactionService.paid(transactionRequest);

    }
}
