package com.ecommerce.ecommerceapplication.model;

import lombok.Data;

@Data
public class OrderResponse {
    private float amount;
    private int invoiceNumber;
    private String date;
    private String OrderDescription;
    private int orderId;
}
