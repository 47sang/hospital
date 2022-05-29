package com.api.hospital.model.vo;

import lombok.Data;

@Data
public class MyCollect {
    private Integer article_id;
    private String article_datetime;
    private String article_title;
    private String doctor_name;
}
