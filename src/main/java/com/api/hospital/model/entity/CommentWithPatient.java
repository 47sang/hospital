package com.api.hospital.model.entity;

import lombok.Data;

@Data
public class CommentWithPatient {
    private Integer comment_id;
    private Integer article_id;
    private Integer patient_id;
    private String comment_content;
    private String comment_datetime;
    private String patient_name;
    private String patient_avatar;
}
