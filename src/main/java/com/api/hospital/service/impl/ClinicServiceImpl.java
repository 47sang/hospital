package com.api.hospital.service.impl;

import com.api.hospital.mapper.ClinicMapper;
import com.api.hospital.model.entity.Clinic;
import com.api.hospital.service.intf.ClinicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private ClinicMapper clinicMapper;

    @Override
    public Clinic getClinicById(int clinic_id) {
        Clinic clinic = clinicMapper.getClinicById(clinic_id);
        if (clinic != null) return clinic;
        else throw new RuntimeException("没有找到该门诊");
    }

    @Override
    public List<Clinic> getClinicByDepartmentId(int department_id) {
        List<Clinic> clinic = clinicMapper.getClinicByDepartmentId(department_id);
        if (clinic.size() > 0) return clinic;
        else throw new RuntimeException("没有找到门诊数据");
    }

    @Override
    public List<Clinic> getClinics() {
        List<Clinic> clinic = clinicMapper.getClinics();
        if (clinic.size() > 0) return clinic;
        else throw new RuntimeException("没有找到门诊数据");
    }

    @Override
    public void updateClinic(Clinic clinic) {
        int result = clinicMapper.updateClinic(clinic);
        if (result != 1) throw new RuntimeException("更新门诊数据失败");
    }

    @Override
    public void insertClinic(Clinic clinic) {
        int result = clinicMapper.insertClinic(clinic);
        if (result != 1) throw new RuntimeException("更新门诊数据失败");
    }

    @Override
    public void deleteClinic(int clinic_id) {
        int result = clinicMapper.deleteClinic(clinic_id);
        if (result != 1) throw new RuntimeException("删除门诊数据失败");
    }
}
