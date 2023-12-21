package com.ecommerce.ecommerceapplication.entity;

import com.ecommerce.ecommerceapplication.repository.CartRepository;
import com.ecommerce.ecommerceapplication.service.CartService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_Table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sNo;
    private UUID orderId;
    private BigDecimal grandTotal;
    private BigDecimal subTotal;
    private BigDecimal discount;
}
