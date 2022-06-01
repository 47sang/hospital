package com.api.hospital.service.impl;

import com.api.hospital.mapper.PatientMapper;
import com.api.hospital.model.entity.Patient;
import com.api.hospital.service.intf.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientMapper patientMapper;

    @Override
    public void insertPatient(Patient patient) {
        int result = patientMapper.insertPatient(patient);
        if (result != 1) throw new RuntimeException("插入患者信息失败");
    }

    @Override
    public Patient getPatientById(int patientId) {
        Patient data = patientMapper.getPatientById(patientId);
        if (data != null) return data;
        else throw new RuntimeException("没有找到对应的患者信息");
    }

    @Override
    public void updatePatient(Patient patient) {
        int result = patientMapper.updatePatient(patient);
        if (result != 1) throw new RuntimeException("更新患者信息失败");
    }

    @Override
    public void deletePatient(int patientId) {
        int result = patientMapper.deletePatient(patientId);
        if (result != 1) throw new RuntimeException("删除患者信息失败");
    }
}

