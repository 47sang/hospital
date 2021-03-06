package com.api.hospital.mapper;

import com.api.hospital.model.entity.ArticleComment;
import com.api.hospital.model.entity.CommentWithPatient;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleCommentMapper {
    /**
     * 根据文章id查询评论总数
     * @param articleId 文章id
     * @return int 文章评论数
     */
    @Select("select count(*) from article_comment where article_id = #{articleId}")
    int getCommentCount(int articleId);

    /**
     * 根据文章id查询所有评论
     * @param articleId 文章id
     * @return List<ArticleComment> 文章评论列表对象
     */
    @Select("select * from article_comment where article_id = #{articleId} order by comment_datetime desc")
    List<ArticleComment> getCommentByArticleId(int articleId);

    /**
     * 根据评论id查询评论
     * @param commentId 评论id
     * @return ArticleComment 评论对象
     */
    @Select("select * from article_comment where comment_id = #{commentId}")
    ArticleComment getCommentById(int commentId);

    /**
     * 根据文章id获取评论列表，并带有患者用户的信息
     * @param articleId 文章id
     * @return List<CommentWithPatient> 评论列表对象
     */
    @Select("select article_comment.comment_id,article_comment.article_id,article_comment.patient_id,article_comment.comment_content," +
            "article_comment.comment_datetime,patient.patient_name,patient.patient_avatar from article_comment " +
            "left join patient on article_comment.patient_id = patient.patient_id where article_id = #{articleId} " +
            "order by comment_datetime desc")
    List<CommentWithPatient> getCommentByArticleIdWithPatient(int articleId);

    /**
     * 插入一条新评论
     * @param articleComment 文章评论
     * @return int 1成功 0失败
     */
    @Options(useGeneratedKeys = true, keyProperty = "comment_id", keyColumn = "comment_id")
    @Insert("insert into article_comment(article_id, patient_id, comment_content) " +
            "values(#{article_id}, #{patient_id}, #{comment_content})")
    int insertComment(ArticleComment articleComment);

    /**
     * 根据评论id更新评论
     * @param articleComment 文章评论
     * @return int 1成功 0失败
     */
    @Update("update article_comment set comment_content = #{comment_content} where comment_id = #{comment_id}")
    int updateComment(ArticleComment articleComment);

    /**
     * 根据评论id删除一条评论
     * @param commentId 评论id
     * @return int 1成功 0失败
     */
    @Delete("delete from article_comment where comment_id = #{commentId}")
    int deleteComment(int commentId);

    /**
     * 根据文章id删除所有评论
     * @param articleId 文章id
     * @return int 被删除的条数
     */
    @Delete("delete from article_comment where article_id = #{articleId}")
    int deleteCommentByArticleId(int articleId);


}
