package com.ecommerce.ecommerceapplication.controller;

import com.ecommerce.ecommerceapplication.entity.Item;
import com.ecommerce.ecommerceapplication.model.ItemRequest;
import com.ecommerce.ecommerceapplication.model.ItemResponse;
import com.ecommerce.ecommerceapplication.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
   @GetMapping("/getItemBySorting/{field}")
   public List<Item> getItemBySorting (@PathVariable String field){
       return itemService.getItemBySorting(field);
   }

   @GetMapping("/getItemWithPagination/{offset}/{pageSize}")
   public Page <Item> getItemByPagination (@PathVariable int offset , @PathVariable int pageSize){
       return itemService.getItemByPagination(offset ,pageSize);

   }

   @GetMapping("/getItemWithPaginationAndSorting/{offset}/{pageSize}/{field}")
   public Page <Item> getItemByPaginationAndSorting (@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
       return itemService.getItemByPaginationAndSorting(offset, pageSize, field);

   }
}
