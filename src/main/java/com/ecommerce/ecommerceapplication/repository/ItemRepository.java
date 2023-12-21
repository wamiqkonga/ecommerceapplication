package com.ecommerce.ecommerceapplication.repository;

import com.ecommerce.ecommerceapplication.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,String> {

    @Query(value = "SELECT COALESCE(SUM(i.item_quantity),0) FROM Item i WHERE i.item_id = :itemId" , nativeQuery = true)
    long countItemQuantity(@Param("itemId") String itemId);


}
