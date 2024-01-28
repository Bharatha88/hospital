package com.hospital.repository;

import com.hospital.dao.ElementEntity;
import org.springframework.data.repository.CrudRepository;


public interface ElementRepository
        extends CrudRepository<ElementEntity,Long> {

    Iterable<ElementEntity> findAllByElementNumber(String elementNumber);


}
