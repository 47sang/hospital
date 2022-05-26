package com.api.hospital.model.entity;

import lombok.Data;

@Data
public class Article {
    private Integer article_id;
    private String article_datetime;
    private String article_title;
    private String article_keywords;
    private String article_content;
    private Integer doctor_id;
    private Integer article_praise;
    private Integer article_views;
    private Integer article_comments;
}
