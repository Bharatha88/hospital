package com.hospital.service;

import com.hospital.dao.ItemEntity;
import com.hospital.dto.Item;

import java.util.List;

public interface ItemService {


    void createItem(Item item);

    List<Item> retrieveAllItems();


    Iterable<ItemEntity> retrieveItemByCode(String code);
    Iterable<ItemEntity> retrieveItemByName(String Name);

    Boolean removeItem(Long itemId);

}
