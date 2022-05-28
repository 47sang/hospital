package com.api.hospital.mapper;

import com.api.hospital.model.entity.ArticleComment;
import com.api.hospital.model.entity.CommentWithPatient;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleCommentMapper {
    @Select("select count(*) from article_comment where article_id = #{article_id}")
    int getCommentCount(int article_id);

    @Select("select * from article_comment where article_id = #{article_id}")
    List<ArticleComment> getCommentByArticleId(int article_id);

    @Select("select * from article_comment where comment_id = #{comment_id}")
    ArticleComment getCommentById(int comment_id);

    @Select("select article_comment.article_id,article_comment.patient_id,article_comment.comment_content," +
            "article_comment.comment_datetime,patient.patient_name,patient.patient_avatar from article_comment " +
            "left join patient on article_comment.patient_id = patient.patient_id where article_id = #{article_id} " +
            "order by comment_datetime desc")
    List<CommentWithPatient> getCommentByArticleIdWithPatient(CommentWithPatient commentWithPatient);

    @Options(useGeneratedKeys = true, keyProperty = "comment_id", keyColumn = "comment_id")
    @Insert("insert into article_comment(article_id, patient_id, comment_content, comment_datetime) " +
            "values(#{article_id}, #{patient_id}, #{comment_content}, #{comment_datetime})")
    int insertComment(ArticleComment articleComment);

    @Update("update article_comment set comment_content = #{comment_content} where comment_id = #{comment_id}")
    int updateComment(ArticleComment articleComment);

    @Delete("delete from article_comment where comment_id = #{comment_id}")
    int deleteComment(int comment_id);


}
