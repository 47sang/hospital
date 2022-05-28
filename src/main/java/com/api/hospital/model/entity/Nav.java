package com.api.hospital.model.entity;

import lombok.Data;

@Data
public class Nav {
    /**
     * 导航
     */
    private Integer nav_id;
    private String nav_title;
    private String nav_icon;
    private String nav_type;
    private String nav_url;
    private Integer nav_sort;
    private String nav_status;
}
