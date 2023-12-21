package com.ecommerce.ecommerceapplication.controller;

import com.ecommerce.ecommerceapplication.model.ItemRequest;
import com.ecommerce.ecommerceapplication.model.ItemResponse;
import com.ecommerce.ecommerceapplication.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ItemController {
   @Autowired
   private ItemService itemService;

   @PostMapping("/saveitem")
   public String saveItem(@RequestBody ItemRequest itemRequest){
       itemRequest.setItemId(UUID.randomUUID().toString());
       itemService.save(itemRequest);
       return "Item saved Successfully";
   }

   @GetMapping("/get/{itemId}")
   public ItemResponse getItems( @PathVariable String itemId ){
       return itemService.getById(itemId);

   }
}
