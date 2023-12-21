package com.ecommerce.ecommerceapplication.entity;

import com.ecommerce.ecommerceapplication.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long serialNo;
    private String cartId;
    private String itemId;
    private double price;
    private Long itemQuantity;
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    private Status status;

    public void calculateTotalPrice() {
        this.totalPrice = this.itemQuantity * this.price;
    }
}
