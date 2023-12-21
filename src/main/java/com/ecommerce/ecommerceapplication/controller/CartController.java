package com.ecommerce.ecommerceapplication.controller;

import com.ecommerce.ecommerceapplication.entity.Cart;
import com.ecommerce.ecommerceapplication.model.CartRequest;
import com.ecommerce.ecommerceapplication.model.CartResponse;
import com.ecommerce.ecommerceapplication.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CartController {
   @Autowired
   private CartService cartService;
   @PostMapping("/save-cart")
    public String saveCart(@RequestBody CartRequest cartRequest){
        cartRequest.setCartId( UUID.randomUUID().toString());
        return cartService.saveCart(cartRequest);
    }

    @GetMapping("/getCart/{cartId}")
    public List <Cart> getCart (@PathVariable String cartId ){
       return cartService.getCart(cartId);

    }

    @PutMapping("/update-cart")
    public String updateCart(@RequestBody CartRequest cartRequest){
         return cartService.updateCart(cartRequest);
    }

//    @DeleteMapping("/delete-cart")
//    public String deleteCart(@RequestBody Cart cart){
//       return cartService.deleteCart(cart);
//    }


}
