package com.api.hospital.mapper;

import com.api.hospital.model.entity.Health;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HealthMapper {
    /*
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
     */
    @Select("select article.article_id,article.article_datetime,article.article_title,article.article_keywords,article.article_content," +
            "article.article_praise,article.article_views,article.doctor_id,doctor.doctor_name,doctor.doctor_avatar from article left join " +
            "doctor on article.doctor_id = doctor.doctor_id order by article.article_id desc limit #{start},#{end}")
    List<Health> getHealth(int start, int end);
}
