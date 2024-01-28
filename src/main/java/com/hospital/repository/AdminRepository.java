package com.hospital.repository;

import com.hospital.dao.AdminEntity;
import org.springframework.data.repository.CrudRepository;


public interface AdminRepository
        extends CrudRepository<AdminEntity,Long> {

    Iterable<AdminEntity> findAllByFirstName(String firstName);

    Iterable<AdminEntity> findAllByLastName(String lastName);


}
