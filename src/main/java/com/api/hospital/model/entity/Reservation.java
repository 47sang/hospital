package com.api.hospital.model.entity;

import lombok.Data;

@Data
public class Reservation {
    /**
     * 患者预约
     */
    private Integer reservation_id;
    private Integer patient_id;
    private Integer doctor_id;
    private Integer department_id;
    private Integer clinic_id;
    private String datetime;
    private Integer serial_number;
}
