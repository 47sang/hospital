package com.api.hospital.service.intf;

import com.api.hospital.model.entity.ArticleComment;
import com.api.hospital.model.entity.CommentWithPatient;

import java.util.List;

public interface CommentService {
    int getCommentCount(int article_id);

    List<ArticleComment> getCommentByArticleId(int article_id);

    ArticleComment getCommentById(int comment_id);

    List<CommentWithPatient> getCommentByArticleIdWithPatient(int article_id);

    void insertComment(ArticleComment articleComment);

    void updateComment(ArticleComment articleComment);

    void deleteComment(int comment_id);


}
