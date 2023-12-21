package com.ecommerce.ecommerceapplication.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderRequest {
    private long sNo;
    private String orderId;
    private BigDecimal subTotal;
    private BigDecimal grandTotal;
    private BigDecimal discount;
    private String cartId;

}
