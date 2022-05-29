package com.api.hospital.mapper;

import com.api.hospital.model.entity.Collect;
import com.api.hospital.model.entity.Praise;
import com.api.hospital.model.vo.MyCollect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PraiseAndCollectMapper {
    /*
     点赞表数据库增删改查操作
     */
    @Select("select * from praise where patient_id=#{patient_id} and article_id=#{article_id}")
    int isPraise(Praise praise);

    @Select("select count(*) from praise where article_id=#{article_id}")
    int getPraiseCount(Praise praise);

    @Insert("insert into praise(patient_id,article_id) values(#{patient_id},#{article_id})")
    int insertPraise(Praise praise);

    @Delete("delete from praise where patient_id=#{patient_id} and article_id=#{article_id}")
    int deletePraise(Praise praise);

    @Delete("delete from praise where article_id=#{article_id}")
    int deletePraiseByArticleId(int article_id);

    /*
     收藏表数据库增删改查操作
     */
    @Select("select * from collect where patient_id=#{patient_id} and article_id=#{article_id}")
    int isCollect(Collect collect);

    @Select("select count(*) from collect where patient_id=#{patient_id}")
    int getCollectCount(int patient_id);


    /*
    TODO:查询某个患者的所有收藏，结果需要【文章标题，文章作者，更新时间】
    private Integer article.article_id;
    private String article.article_datetime;
    private String article.article_title;
    private String doctor.doctor_name;
     */
    @Select("select article.article_id, article.article_title, article.article_datetime, doctor.doctor_name, " +
            "from article, doctor, collect where collect.article_id = article.article_id and " +
            "article.doctor_id = doctor.doctor_id and collect.patient_id = #{patient_id} ORDER BY collect.collect_id DESC")
    List<MyCollect> getCollectByPatientId(int patient_id);

    @Insert("insert into collect(patient_id,article_id) values(#{patient_id},#{article_id})")
    int insertCollect(Collect collect);

    @Delete("delete from collect where patient_id=#{patient_id} and article_id=#{article_id}")
    int deleteCollect(Collect collect);


}