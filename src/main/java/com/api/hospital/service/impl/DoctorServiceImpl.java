package com.api.hospital.service.impl;

import com.api.hospital.mapper.DoctorMapper;
import com.api.hospital.model.entity.Doctor;
import com.api.hospital.service.intf.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public void insertDoctor(Doctor doctor) {
        int result = doctorMapper.insertDoctor(doctor);
        if (result != 1) {
            throw new RuntimeException("插入医生信息失败");
        }
    }

    @Override
    public Doctor getDoctorById(int doctorId) {
        Doctor data = doctorMapper.getDoctorById(doctorId);
        if (data != null) {
            return data;
        } else {
            throw new RuntimeException("没有找到对应的医生信息");
        }
    }

    @Override
    public Doctor getDoctorByName(String doctorName) {
        Doctor data = doctorMapper.getDoctorByName(doctorName);
        if (data != null) {
            return data;
        } else {
            throw new RuntimeException("没有找到对应的医生信息");
        }
    }

    @Override
    public List<Doctor> getDoctorByDepartmentId(int departmentId) {
        List<Doctor> data = doctorMapper.getDoctorByDepartmentId(departmentId);
        if (data.size() > 0) {
            return data;
        } else {
            throw new RuntimeException("没有任何医生信息");
        }
    }

    @Override
    public List<Doctor> getDoctorByClinicId(int clinicId) {
        List<Doctor> data = doctorMapper.getDoctorByClinicId(clinicId);
        if (data.size() > 0) {
            return data;
        } else {
            throw new RuntimeException("没有任何医生信息");
        }
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        int result = doctorMapper.updateDoctor(doctor);
        if (result != 1) {
            throw new RuntimeException("更新医生信息失败");
        }
    }

    @Override
    public void deleteDoctor(int doctorId) {
        int result = doctorMapper.deleteDoctor(doctorId);
        if (result != 1) {
            throw new RuntimeException("删除医生信息失败");
        }
    }
}
