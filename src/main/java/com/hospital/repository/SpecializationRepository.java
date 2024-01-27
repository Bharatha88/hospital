package com.hospital.repository;


import com.hospital.dao.SpecializationEntity;
import org.springframework.data.repository.CrudRepository;

public interface SpecializationRepository
        extends CrudRepository<SpecializationEntity,Long> {
}

