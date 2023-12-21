package com.ecommerce.ecommerceapplication.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
public class Item {
    @Id
    private String itemId;
    private String itemName;
    private Long itemPrice;
    private Long itemQuantity;
}
