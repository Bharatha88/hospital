package com.hospital.repository;

import com.hospital.dao.ItemEntity;
import org.springframework.data.repository.CrudRepository;


public interface ItemRepository
        extends CrudRepository<ItemEntity,Long> {

    Iterable<ItemEntity> findAllByCode(String code);

    Iterable<ItemEntity> findAllByName(String name);


}
