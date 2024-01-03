package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.entity.Allergens;
import com.ecommerce.ecommerceapplication.entity.Dietaries;
import com.ecommerce.ecommerceapplication.entity.Item;
import com.ecommerce.ecommerceapplication.model.DietariesRequest;
import com.ecommerce.ecommerceapplication.repository.DietariesRepository;
import com.ecommerce.ecommerceapplication.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietariesService {
    @Autowired
    DietariesRepository dietariesRepository;
    @Autowired
    ItemRepository itemRepository;

    public List<Dietaries> getByDietariesName(String dietariesName) {
        return dietariesRepository.findByDietariesName(dietariesName);

    }


    public void saveDietaries(DietariesRequest dietariesRequest) {
        String itemId = dietariesRequest.getItemId();
        Item itemDietary = itemRepository.findById(itemId).get();
        Dietaries dietaries = new Dietaries();
        dietaries.setItemId(itemId);
        dietaries.setDietariesId(dietariesRequest.getDietariesId());
        dietaries.setDietariesName(dietariesRequest.getDietariesName());
        dietariesRepository.save(dietaries);
    }

    public List<Dietaries> getAll(String field) {
       return dietariesRepository.findAll(Sort.by(field));
    }


}

