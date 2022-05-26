package com.api.hospital.model.entity;

import lombok.Data;

@Data
public class Patient {
    /**
     * 患者信息
     */
    private Integer patient_id;
    private String patient_name;
    private String patient_card_id;
    private String patient_born_date;
    private String patient_sex;
    private Integer patient_phone;
    private Integer patient_medical_card;
    private String patient_avatar;

}
