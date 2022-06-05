package com.api.hospital.service.intf;

import com.api.hospital.model.entity.Patient;
import org.springframework.web.multipart.MultipartFile;

public interface PatientService {
    void insertPatient(Patient patient);

    void insertPatient(Patient patient, MultipartFile file);

    Patient getPatientById(int patientId);

    void updatePatient(Patient patient);

    void updatePatient(Patient patient, MultipartFile file);

    void deletePatient(int patientId);
}
