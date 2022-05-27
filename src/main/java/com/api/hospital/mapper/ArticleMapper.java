package com.api.hospital.mapper;

import com.api.hospital.model.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Select("select * from article where article_id = #{article_id}")
    Article getArticleById(int article_id);

    @Delete("delete from article where article_id = #{article_id}")
    int deleteArticleById(int article_id);

    @Update("update article set article_title = #{article_title}, article_keywords = #{article_keywords}," +
            " article_content = #{article_content} where article_id = #{article_id}")
    int updateArticleById(Article article);

    @Insert("insert into article( article_title, article_keywords, article_content, doctor_id,article_type) values(#{article_title}," +
            " #{article_keywords}, #{article_content}, #{doctor_id},#{article_type})")
    int insertArticle(Article article);

    @Select("select * from article order by article_id desc")
    Article[] getArticles();

    @Select("select * from article where article_type = #{article_type} order by article_id desc limit #{start},#{end}")
    List<Article> getArticlesByTypeInStartAndEnd(String article_type, int start, int end);

    @Select("select * from article where article_type = #{article_type} order by article_id desc")
    List<Article> getArticlesByType(String article_type);

}
