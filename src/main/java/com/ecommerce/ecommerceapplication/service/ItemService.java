package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.entity.Item;
import com.ecommerce.ecommerceapplication.model.ItemRequest;
import com.ecommerce.ecommerceapplication.model.ItemResponse;
import com.ecommerce.ecommerceapplication.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public void save(ItemRequest itemRequest) {
        Item item = new Item();
        item.setItemId(itemRequest.getItemId());
        item.setItemName(itemRequest.getItemName());
        item.setItemPrice(itemRequest.getItemPrice());
        item.setItemQuantity(itemRequest.getItemQuantity());

       itemRepository.save(item);
    }

    public ItemResponse getById(String itemId) {
        Item item = itemRepository.getById(itemId);
        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setItemId(item.getItemId());
        itemResponse.setItemName(item.getItemName());
        itemResponse.setItemPrice(item.getItemPrice());
        itemResponse.setItemQuantity(item.getItemQuantity());
        return itemResponse;
    }
}
