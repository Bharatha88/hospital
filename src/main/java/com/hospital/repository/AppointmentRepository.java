package com.hospital.repository;

import com.hospital.dao.AppointmentEntity;
import org.springframework.data.repository.CrudRepository;


public interface AppointmentRepository
        extends CrudRepository<AppointmentEntity,Long> {

    Iterable<AppointmentEntity> findAllByDoctorName(String doctorName);

    Iterable<AppointmentEntity> findAllByPatientName(String patientName);


}
