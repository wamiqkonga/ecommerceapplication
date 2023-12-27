package com.ecommerce.ecommerceapplication.repository;

import com.ecommerce.ecommerceapplication.entity.Cart;
import com.ecommerce.ecommerceapplication.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart , Long> {
    Cart findByCartIdAndItemId(String cartId, String itemId);


    Cart findByCartId(String cartId);
}
