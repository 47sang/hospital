package com.api.hospital.controller;

import com.api.hospital.model.dto.ResponseInfo;
import com.api.hospital.model.entity.Patient;
import com.api.hospital.service.intf.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "患者信息接口")
@RestController
@RequestMapping(value = "/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;


    @ApiOperation("插入患者信息")
    @PostMapping("")
    public ResponseInfo insertPatient(Patient patient, @RequestParam(value = "file", required = false) MultipartFile file) {
        ResponseInfo responseInfo = new ResponseInfo();
        try {
            if (file == null) {
                patientService.insertPatient(patient);
            } else {
                patientService.insertPatient(patient, file);
            }
            responseInfo.setData(patient);
        } catch (Exception e) {
            responseInfo.setCode(500);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation("根据id获取患者信息")
    @GetMapping("/{patientId}")
    public ResponseInfo getPatientById(@PathVariable(value = "patientId") int patientId) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String, Patient> data = new HashMap<>();
        try {
            data.put("patient", patientService.getPatientById(patientId));
            responseInfo.setData(data);
        } catch (Exception e) {
            responseInfo.setCode(500);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation("更新患者信息")
    @PutMapping("")
    public ResponseInfo updatePatient(Patient patient, @RequestParam(value = "file", required = false) MultipartFile file) {
        ResponseInfo responseInfo = new ResponseInfo();
        try {
            if (file == null) {
                patientService.updatePatient(patient);
            } else {
                patientService.updatePatient(patient, file);
            }
            responseInfo.setData(patient);
        } catch (Exception e) {
            responseInfo.setCode(500);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation("删除患者信息")
    @DeleteMapping("/{patientId}")
    public ResponseInfo deletePatient(@PathVariable(value = "patientId") int patientId) {
        ResponseInfo responseInfo = new ResponseInfo();
        try {
            patientService.deletePatient(patientId);
        } catch (Exception e) {
            responseInfo.setCode(500);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }
}
