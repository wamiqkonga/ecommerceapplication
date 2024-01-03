package com.ecommerce.ecommerceapplication.controller;

import com.ecommerce.ecommerceapplication.entity.Allergens;
import com.ecommerce.ecommerceapplication.entity.Dietaries;
import com.ecommerce.ecommerceapplication.model.AllergensRequest;
import com.ecommerce.ecommerceapplication.model.ItemResponse;
import com.ecommerce.ecommerceapplication.service.AllergensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AllergensController {
    @Autowired
    AllergensService allergensService;
    @PostMapping("/save-allergens")
    public String saveAllergens(@RequestBody AllergensRequest allergensRequest){
        allergensService.saveAllergens(allergensRequest);
        return "Allergens Saved Successfully";
    }
    @GetMapping("/get-allergens/{fields}")
    public List <Allergens> getAll(@PathVariable String fields) {
        return allergensService.getAll(fields);
    }

    @GetMapping("/getByAllergensName/{allergensName}")
    public List<Allergens> getAllergensByName(@PathVariable String allergensName ) {
        return allergensService.getByAllergensName(allergensName);
    }
}
