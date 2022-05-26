package com.api.hospital.model.entity;

import lombok.Data;

@Data
public class Pay {
    /**
     * 缴费记录
     */
    private Integer pay_id;
    private String pay_datetime;
    private String pay_money;
    private String pay_type;
    private String pay_status;
    private Integer patient_id;
}
