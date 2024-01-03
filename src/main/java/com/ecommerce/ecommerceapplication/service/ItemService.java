package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.entity.Dietaries;
import com.ecommerce.ecommerceapplication.entity.Item;
import com.ecommerce.ecommerceapplication.model.ItemRequest;
import com.ecommerce.ecommerceapplication.model.ItemResponse;
import com.ecommerce.ecommerceapplication.repository.DietariesRepository;
import com.ecommerce.ecommerceapplication.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Slf4j
@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private DietariesRepository dietariesRepository;

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

    public List<Item> getItemBySorting (String field ){
        return itemRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION,field));
    }

    public Page <Item> getItemByPagination (int offset , int pageSize){
        Page<Item> items = itemRepository.findAll(PageRequest.of(offset , pageSize));
        return items;
    }

    public Page<Item> getItemByPaginationAndSorting (int offset,int pageSize,String field){
        log.info("offset--" + offset);
        log.info("pageSize--" + pageSize);
        log.info("field--" + field);
        return itemRepository.findAll(PageRequest.of(offset , pageSize).withSort(Sort.by(field)));

    }
}
