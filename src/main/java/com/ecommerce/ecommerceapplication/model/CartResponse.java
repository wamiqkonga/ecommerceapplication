package com.ecommerce.ecommerceapplication.model;

import lombok.Data;

@Data
public class CartResponse {
    private String cartId;
    private String itemId;
    private Long itemQuantity;
}
