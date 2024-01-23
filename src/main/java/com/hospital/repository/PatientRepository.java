package com.hospital.repository;

import com.hospital.dao.PatientEntity;
import org.springframework.data.repository.CrudRepository;


public interface PatientRepository
        extends CrudRepository<PatientEntity,Long> {

    Iterable<PatientEntity> findAllByFirstName(String firstName);

    Iterable<PatientEntity> findAllByLastName(String lastName);


}
