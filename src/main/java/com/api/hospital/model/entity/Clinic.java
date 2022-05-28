package com.api.hospital.model.entity;

import lombok.Data;

@Data
public class Clinic {
    /**
     * 科室门诊
     */
    private Integer clinic_id;
    private String clinic_name;
    private Integer department_id;
}
