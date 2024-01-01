package com.ecommerce.ecommerceapplication.entity;

import com.ecommerce.ecommerceapplication.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID transId;
    private UUID orderId;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdDate;
    @Enumerated(EnumType.STRING)
    private Status status;
}
