package com.hospital.service;


import com.hospital.dao.PrescriptionEntity;
import com.hospital.dto.Prescription;

import java.util.List;

public interface PrescriptionService {


    void createPrescription(Prescription prescription);

    List<Prescription> retrieveAllPrescriptions(String prescriptionNumber);

    Iterable<PrescriptionEntity> retrievePrescriptionByPrescriptionNumber(String prescriptionNumber);


    Boolean removePrescription(Long prescriptionId);


}
