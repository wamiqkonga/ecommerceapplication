package com.ecommerce.ecommerceapplication.model;

import com.ecommerce.ecommerceapplication.enums.Status;
import lombok.Data;

@Data
public class CartRequest {
    Long serialNo;
    private String cartId;
    private double price;
    private String itemId;
    private Long itemQuantity;
    private double totalPrice;
    private Status status;

}
