package com.hospital.service;

import com.hospital.dao.ItemEntity;
import com.hospital.dto.Element;
import com.hospital.dto.Item;

import java.util.List;

public interface ItemService {


    void createItem(Item item);

    List<Item> retrieveAllItems(String code, String name);

    Iterable<ItemEntity> retrieveItemByCode(String code);

    Iterable<ItemEntity> retrieveItemByName(String Name);

    Boolean removeItem(Long itemId);

    boolean updateItem(Long itemId, Item updatedItem);

}
