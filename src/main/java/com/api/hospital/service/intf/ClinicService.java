package com.api.hospital.service.intf;

import com.api.hospital.model.entity.Clinic;

import java.util.List;

public interface ClinicService {
    Clinic getClinicById(int clinic_id);

    List<Clinic> getClinicByDepartmentId(int department_id);

    List<Clinic> getClinics();

    void updateClinic(Clinic clinic);

    void insertClinic(Clinic clinic);

    void deleteClinic(int clinic_id);
}
