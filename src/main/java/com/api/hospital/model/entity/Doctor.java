package com.api.hospital.model.entity;

import lombok.Data;

@Data
public class Doctor {
    /**
     * 医生信息
     */
    private Integer doctor_id;
    private String doctor_name;
    private String doctor_avatar;
    private String doctor_title;
    private String doctor_specialty;
    private String doctor_resume;
    private Integer department_id;
    private Integer clinic_id;
}
