package com.hospital.repository;


import com.hospital.dao.DoctorEntity;
import org.springframework.data.repository.CrudRepository;


public interface DoctorRepository
        extends CrudRepository<DoctorEntity,Long> {

    Iterable<DoctorEntity> findAllByFirstName(String firstName);

    Iterable<DoctorEntity> findAllByLastName(String lastName);


}
