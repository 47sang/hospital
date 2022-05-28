package com.api.hospital.model.vo;

import lombok.Data;

@Data
public class Health {
    private Integer article_id;
    private String article_datetime;
    private String article_title;
    private String article_keywords;
    private String article_content;
    private Integer article_praise;
    private Integer article_views;
    private Integer doctor_id;
    private String doctor_name;
    private String doctor_avatar;
}