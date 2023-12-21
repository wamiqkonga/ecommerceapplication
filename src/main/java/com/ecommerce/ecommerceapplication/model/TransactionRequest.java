package com.ecommerce.ecommerceapplication.model;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;
import java.util.UUID;

@Data
public class TransactionRequest {

    private UUID transId;
    private UUID orderId;
    private Calendar createdDate;
}
