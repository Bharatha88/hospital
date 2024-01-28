package com.hospital.repository;

import com.hospital.dao.BillEntity;
import org.springframework.data.repository.CrudRepository;


public interface BillRepository
        extends CrudRepository<BillEntity,Long> {

    Iterable<BillEntity> findAllByBillNumber(String billNumber);


}
