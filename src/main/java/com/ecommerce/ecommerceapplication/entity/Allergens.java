package com.ecommerce.ecommerceapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Allergens {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long allergensId;
    private String allergensName;
    private String itemId;
}
