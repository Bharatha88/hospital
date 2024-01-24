package com.hospital.repository.impl;

import com.hospital.repository.PatientNativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Repository
public class PatientNativeRepositoryImpl implements PatientNativeRepository {

    @Autowired
    NamedParameterJdbcTemplate  namedParameterJdbcTemplate;

    public boolean removePatient(Long id){
        return namedParameterJdbcTemplate.update(
                "DELETE FROM PATIENT WHERE ID=:id",
                Collections.singletonMap("id",id)) > 0;

    }
}
