package com.api.hospital.model.vo;

import com.api.hospital.model.entity.Article;
import com.api.hospital.model.entity.Department;
import com.api.hospital.model.entity.Nav;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WxHome implements Serializable {
    private List<Nav> navs;
    private List<Article> headlines;
    private List<Article> banners;
    private List<Nav> general;
    private List<Department> departments;
    private List<Article> healthPush;
    /*

     */
}
