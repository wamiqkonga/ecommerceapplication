package com.ecommerce.ecommerceapplication.repository;

import com.ecommerce.ecommerceapplication.entity.Allergens;
import com.ecommerce.ecommerceapplication.entity.Dietaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllergensRepository extends JpaRepository<Allergens , Long> {
    List<Allergens> getByAllergensName(String allergensName);
}
