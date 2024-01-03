package com.ecommerce.ecommerceapplication.repository;

import com.ecommerce.ecommerceapplication.entity.Dietaries;
import com.ecommerce.ecommerceapplication.model.DietariesRequest;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.metamodel.SingularAttribute;
import java.io.Serializable;
import java.util.List;

@Repository
public interface DietariesRepository extends JpaRepository<Dietaries, Long> {
  List <Dietaries> findByDietariesName(String dietariesName);
}
