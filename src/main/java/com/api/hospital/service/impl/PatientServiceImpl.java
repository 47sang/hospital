package com.api.hospital.service.impl;

import com.api.hospital.mapper.PatientMapper;
import com.api.hospital.model.entity.Patient;
import com.api.hospital.service.intf.PatientService;
import com.api.hospital.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientMapper patientMapper;

    @Value("${file.path}")
    private String uploadPath;

    @Override
    public void insertPatient(Patient patient) {
        int result = patientMapper.insertPatient(patient);
        if (result != 1) {
            throw new RuntimeException("插入患者信息失败");
        }
    }

    @Override
    public void insertPatient(Patient patient, MultipartFile file) {
        String avatar = new FileUtils().uploadImg(file, uploadPath);
        patient.setPatient_avatar(avatar);
        int result = patientMapper.insertPatient(patient);
        if (result != 1) {
            throw new RuntimeException("插入患者信息失败");
        }
    }

    @Override
    public Patient getPatientById(int patientId) {
        Patient data = patientMapper.getPatientById(patientId);
        if (data != null) {
            return data;
        } else {
            throw new RuntimeException("没有找到对应的患者信息");
        }
    }

    @Override
    public void updatePatient(Patient patient) {
        int result = patientMapper.updatePatient(patient);
        if (result != 1) {
            throw new RuntimeException("更新患者信息失败");
        }
    }

    @Override
    public void updatePatient(Patient patient, MultipartFile file) {
        String avatar = new FileUtils().uploadImg(file, uploadPath);
        patient.setPatient_avatar(avatar);
        int result = patientMapper.updatePatient(patient);
        if (result != 1) {
            throw new RuntimeException("更新患者信息失败");
        }
    }

    @Override
    public void deletePatient(int patientId) {
        int result = patientMapper.deletePatient(patientId);
        if (result != 1) {
            throw new RuntimeException("删除患者信息失败");
        }
    }
}

