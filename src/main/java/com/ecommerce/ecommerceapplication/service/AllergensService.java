package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.entity.Allergens;
import com.ecommerce.ecommerceapplication.entity.Dietaries;
import com.ecommerce.ecommerceapplication.entity.Item;
import com.ecommerce.ecommerceapplication.model.AllergensRequest;
import com.ecommerce.ecommerceapplication.repository.AllergensRepository;
import com.ecommerce.ecommerceapplication.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AllergensService {
    @Autowired
    AllergensRepository allergensRepository;
    @Autowired
    ItemRepository itemRepository;
    public void saveAllergens(AllergensRequest allergensRequest) {
        String itemId = allergensRequest.getItemId();

        Item itemAllergen = itemRepository.findById(itemId).get();
        Allergens allergens = new Allergens();
        allergens.setItemId(itemId);
        allergens.setAllergensId(allergensRequest.getAllergensId());
        allergens.setAllergensName(allergensRequest.getAllergensName());
        allergensRepository.save(allergens);
    }

    public List<Allergens> getAll(String fields) {
        return allergensRepository.findAll(Sort.by(fields));
    }


    public List<Allergens> getByAllergensName(String allergensName) {
        return allergensRepository.getByAllergensName(allergensName);
    }
}
