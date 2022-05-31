package com.api.hospital.mapper;

import com.api.hospital.model.entity.Collect;
import com.api.hospital.model.entity.Praise;
import com.api.hospital.model.vo.MyCollect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhou
 */
@Mapper
public interface PraiseAndCollectMapper {
    /**
     * 点赞表数据库增删改查操作
     * @param praise 点赞对象
     * @return int
     */
    @Select("select * from praise where patient_id=#{patient_id} and article_id=#{article_id}")
    int isPraise(Praise praise);

    /**
     * 根据article_id获取点赞数量
     * @param praise article_id
     * @return int praise_count
     */
    @Select("select count(*) from praise where article_id=#{article_id}")
    int getPraiseCount(Praise praise);

    /**
     * 插入一条点赞数据
     * @param praise 点赞对象
     * @return int 1成功 0失败
     */
    @Insert("insert into praise(patient_id,article_id) values(#{patient_id},#{article_id})")
    int insertPraise(Praise praise);

    /**
     * 取消点赞
     * @param praise 点赞对象
     * @return int 1成功 0失败
     */
    @Delete("delete from praise where patient_id=#{patient_id} and article_id=#{article_id}")
    int deletePraise(Praise praise);

    /**
     * 根据article_id删除点赞数据
     * @param article_id 文章id
     * @return int 1成功 0失败
     */
    @Delete("delete from praise where article_id=#{article_id}")
    int deletePraiseByArticleId(int article_id);


    /**
     * 判断是否收藏
     * @param collect 点赞对象
     * @return int 1成功 0失败
     */
    @Select("select * from collect where patient_id=#{patient_id} and article_id=#{article_id}")
    int isCollect(Collect collect);

    /**
     * 获取当前患者的收藏数量
     * @param patient_id 患者id
     * @return int 收藏数量
     */
    @Select("select count(*) from collect where patient_id=#{patient_id}")
    int getCollectCount(int patient_id);

    /**
     * 获取当前患者的收藏列表
     * @param patient_id 患者id
     * @return List<MyCollect> 文章收藏列表
     */
    @Select("select article.article_id, article.article_title, article.article_datetime, doctor.doctor_name, " +
            "from article, doctor, collect where collect.article_id = article.article_id and " +
            "article.doctor_id = doctor.doctor_id and collect.patient_id = #{patient_id} ORDER BY collect.collect_id DESC")
    List<MyCollect> getCollectByPatientId(int patient_id);

    /**
     * 插入一条收藏数据
     * @param collect 点赞对象
     * @return int 1成功 0失败
     */
    @Insert("insert into collect(patient_id,article_id) values(#{patient_id},#{article_id})")
    int insertCollect(Collect collect);

    /**
     * 取消收藏
     * @param collect 点赞对象
     * @return int 1成功 0失败
     */
    @Delete("delete from collect where patient_id=#{patient_id} and article_id=#{article_id}")
    int deleteCollect(Collect collect);

}