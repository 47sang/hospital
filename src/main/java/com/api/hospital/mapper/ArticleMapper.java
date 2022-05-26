package com.api.hospital.mapper;

import com.api.hospital.model.entity.Article;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ArticleMapper {
    @Select("select * from article where article_id = #{article_id}")
    Article getArticleById(int article_id);

    @Delete("delete from article where article_id = #{article_id}")
    int deleteArticleById(int article_id);

    @Update("update article set article_title = #{article_title}, article_keywords = #{article_keywords}," +
            " article_content = #{article_content}, doctor_id = #{doctor_id}, article_praise = #{article_praise}," +
            " article_comments = #{article_comments}, article_status = #{article_status}" +
            " where article_id = #{article_id}")
    int updateArticleById(Article article);

    @Insert("insert into article( article_title, article_keywords, article_content, doctor_id) values(#{article_title}," +
            " #{article_keywords}, #{article_content}, #{doctor_id})")
    int insertArticle(Article article);

}
