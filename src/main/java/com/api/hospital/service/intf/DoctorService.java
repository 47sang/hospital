package com.api.hospital.service.intf;

import com.api.hospital.model.entity.Doctor;

import java.util.List;

public interface DoctorService {
    void insertDoctor(Doctor doctor);

    Doctor getDoctorById(int doctorId);

    Doctor getDoctorByName(String doctorName);

    List<Doctor> getDoctorByDepartmentId(int departmentId);

    List<Doctor> getDoctorByClinicId(int clinicId);

    void updateDoctor(Doctor doctor);

    void deleteDoctor(int doctorId);

}
