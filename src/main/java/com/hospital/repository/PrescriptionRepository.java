package com.hospital.repository;

import com.hospital.dao.AppointmentEntity;
import com.hospital.dao.PrescriptionEntity;
import org.springframework.data.repository.CrudRepository;


public interface PrescriptionRepository
        extends CrudRepository<PrescriptionEntity,Long> {


    Iterable<PrescriptionEntity> findAllByPrescriptionNumber(String prescriptionNumber);
}
