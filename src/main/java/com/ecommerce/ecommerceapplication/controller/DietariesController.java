package com.ecommerce.ecommerceapplication.controller;

import com.ecommerce.ecommerceapplication.entity.Dietaries;
import com.ecommerce.ecommerceapplication.model.DietariesRequest;
import com.ecommerce.ecommerceapplication.model.ItemResponse;
import com.ecommerce.ecommerceapplication.service.DietariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DietariesController {
    @Autowired
    DietariesService dietariesService;
    @PostMapping("/save-dietaries")
    public String saveDietaries (@RequestBody DietariesRequest dietariesRequest){
        dietariesService.saveDietaries(dietariesRequest);
       return ("Dietaries Added");
    }

    @GetMapping("/get-dietaries/{field}")
    public List<Dietaries> getDietaries(@PathVariable String field ) {
        return dietariesService.getAll(field) ;

    }

    @GetMapping("/getByName/{dietariesName}")
    public List<Dietaries> getDietariesByName(@PathVariable String dietariesName ) {
        return dietariesService.getByDietariesName(dietariesName);
    }

}
