package com.api.hospital.service.intf;

import com.api.hospital.model.entity.Patient;

public interface PatientService {
    void insertPatient(Patient patient);

    Patient getPatientById(int patientId);

    void updatePatient(Patient patient);

    void deletePatient(int patientId);
}
