package com.api.hospital.model.vo;

import com.api.hospital.model.entity.Article;
import com.api.hospital.model.entity.Department;
import com.api.hospital.model.entity.Nav;
import lombok.Data;

import java.util.List;

@Data
public class WxHome {
    private List<Nav> navs;
    private List<Article> news;
    private List<Article> banners;
    private List<Nav> general;
    private List<Nav> special;
    private List<Department> departments;
    private List<Article> healthPush;
}
