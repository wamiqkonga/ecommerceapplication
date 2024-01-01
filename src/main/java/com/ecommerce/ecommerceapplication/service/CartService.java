package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.entity.Cart;
import com.ecommerce.ecommerceapplication.entity.Item;
import com.ecommerce.ecommerceapplication.enums.Status;
import com.ecommerce.ecommerceapplication.model.CartRequest;
import com.ecommerce.ecommerceapplication.repository.CartRepository;
import com.ecommerce.ecommerceapplication.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j

@Service
public class CartService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CartRepository cartRepository;


    public String saveCart(CartRequest cartRequest) {
        String itemId = cartRequest.getItemId();
        Long itemQuantity = cartRequest.getItemQuantity();

        boolean isExists = itemRepository.existsById(itemId);
        Long availableQuantity = itemRepository.countItemQuantity(itemId);

        log.info("======quantity======", +availableQuantity);

        if (isExists) {
            if (availableQuantity >= itemQuantity) {
                if (itemQuantity < 0) {
                    updateItemQuantityInItemTable(itemId,availableQuantity - itemQuantity);
                    return "Quantity Decreased by " + itemQuantity;
                } else {
                    Cart cart = new Cart();
                    cart.setPrice(cartRequest.getPrice());
                    cart.setSerialNo(cartRequest.getSerialNo());
                    cart.setCartId(cartRequest.getCartId());
                    cart.setItemId(itemId);
                    cart.setStatus(Status.ACTIVE);
                    cart.setItemQuantity(itemQuantity);
                    cart.calculateTotalPrice();


                    cartRepository.save(cart);
                    // Add logging statements
                    log.info("Item ID: {}", itemId);
                    log.info("Available Quantity Before Update: {}", availableQuantity);





                        updateItemQuantityInItemTable(itemId, availableQuantity - itemQuantity);




                    return "Item Saved Successfully";
                }

            } else
                return "Out Of Stock";
        } else
            return "Item doesn't exist";


    }

    private void updateItemQuantityInItemTable(String itemId, long newQuantity) {
        Item item = itemRepository.findById(itemId).get();

        if (item != null) {
            item.setItemQuantity(newQuantity);
            itemRepository.save(item);
        }
    }

    private void updateItemQuantityInCart(Long serialNo, long newQuantity) {
        Cart cart = cartRepository.findById(serialNo).get();

        if (cart != null) {
            cart.setItemQuantity(newQuantity);
            cartRepository.save(cart);
        }
    }

    public String updateCart(CartRequest cartRequest) {
        long itemQuantity = cartRequest.getItemQuantity();

        Cart existingCart = cartRepository.findByCartIdAndItemId(cartRequest.getCartId(), cartRequest.getItemId());
        if (existingCart != null && itemQuantity < 0) {
            existingCart.setItemQuantity(existingCart.getItemQuantity() + cartRequest.getItemQuantity());
            cartRepository.save(existingCart);
            return "quantity decreases";

        } else {
            if (existingCart != null) {
                existingCart.setItemQuantity(cartRequest.getItemQuantity() + existingCart.getItemQuantity());
                existingCart.calculateTotalPrice();
                cartRepository.save(existingCart);
                return "Item quantity updated successfully";
            } else {
                Cart cart = new Cart();

                cart.setCartId(cartRequest.getCartId());
                cart.setItemId(cartRequest.getItemId());
                cart.setPrice(cartRequest.getPrice());
                cart.setItemQuantity(cartRequest.getItemQuantity());
                cart.calculateTotalPrice();

                cartRepository.save(cart);
            }
        }
        return "Updated successfully";
    }

    public List<Cart> getAllCartBySorting (String field) {
        return cartRepository.findAll(Sort.by(Sort.Direction.ASC , field));

    }



}
//        public String updateCart(CartRequest cartRequest) {
//            String cartId = cartRequest.getCartId();
//            String itemId = cartRequest.getItemId();
//            long itemQuantity = cartRequest.getItemQuantity();
//            long availableQuantity = itemRepository.countItemQuantity(itemId);
//
//
//
//         if (cartRequest.getCartId().equals(cartRequest.getItemId())) {
//            Cart existingCart = cartRepository.findById(cartRequest.getSerialNo()).orElse(null);
//                if (existingCart != null) {
//                    if (availableQuantity >= (itemQuantity + existingCart.getItemQuantity())) {
////                 updateItemQuantityInItemTable(itemId, availableQuantity-(existingCart.getItemQuantity() + itemQuantity));
//                        existingCart.setSerialNo(cartRequest.getSerialNo());
//                        existingCart.setCartId(cartId);
//                        existingCart.setItemQuantity(itemQuantity + existingCart.getItemQuantity());
//                        cartRepository.save(existingCart);
//                        return "Cart Updated Successfully";
//                    } else
//
//                        return "Not enough stock to update the cart";
//
//                } else
//                    return "Cart not found";
//            }else
//            {
//                Cart cart = new Cart();
//                cart.setItemQuantity(cart.getItemQuantity());
//                cart.setItemId(cart.getItemId();
//                cart.setCartId(itemQuantity);
//                cartRepository.save(cart);
//        }
//            return "Updated";
//        }
//////
//public String updateCart(CartRequest cartRequest) {
//    String cartId = cartRequest.getCartId();
//    String itemId = cartRequest.getItemId();
//    long itemQuantity = cartRequest.getItemQuantity();
//    long availableQuantity = itemRepository.countItemQuantity(itemId);
//    Cart existingCart = cartRepository.findById(cartRequest.getCartId()).orElse(null);
//
//
//     if ((cartRepository.existsById(itemId))) {
//        cartRequest.setItemQuantity(cartRequest.getItemQuantity());
//        cartRepository.save(existingCart);
////                 updateItemQuantityInItemTable(itemId, availableQuantity-(existingCart.getItemQuantity() + itemQuantity));
//            } else{
//                Cart cart = new Cart();
//                existingCart.setCartId(cartId);
//                existingCart.setItemId(itemId);
//                existingCart.setItemQuantity(cart.getItemQuantity());
//                cartRepository.save(existingCart);
//
//
//
//
//}
//    return "updated Successfully";
//}



//    public String deleteCart(Cart cart) {
//        String itemId = cart.getItemId();
//        Long itemQuantity = cart.getItemQuantity();
//        Long availableQuantity = itemRepository.countItemQuantity(itemId);
//
//        if (itemQuantity < 1) {
//            return "Invalid Quantity input can't be less than 1";
//        } else {
//            Cart existingCart = cartRepository.findById(cart.getCartId()).orElse(null);
//
//            if (existingCart != null ) {
//
//                if (availableQuantity >= (itemQuantity + existingCart.getItemQuantity())) {
//
//                    existingCart.setItemQuantity(existingCart.getItemQuantity()-itemQuantity);
//                    cartRepository.save(existingCart);
//                    return "Cart Updated Successfully";
//                }
//                else
//                    return "Not enough stock to update the cart";
//
//            } else
//                return "Cart not found";
//        }
//    }




