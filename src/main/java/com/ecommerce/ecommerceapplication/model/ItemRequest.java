package com.ecommerce.ecommerceapplication.model;

import lombok.Data;

@Data
public class ItemRequest {
    private String itemId;
    private String itemName;
    private Long itemPrice;
    private Long itemQuantity;
}
