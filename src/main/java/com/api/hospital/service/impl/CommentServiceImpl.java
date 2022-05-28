package com.api.hospital.service.impl;

import com.api.hospital.mapper.ArticleCommentMapper;
import com.api.hospital.mapper.ArticleMapper;
import com.api.hospital.model.entity.ArticleComment;
import com.api.hospital.model.entity.CommentWithPatient;
import com.api.hospital.service.intf.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private ArticleCommentMapper articleCommentMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public int getCommentCount(int article_id) {
        return 0;
    }

    @Override
    public List<ArticleComment> getCommentByArticleId(int article_id) {
        return null;
    }

    @Override
    public ArticleComment getCommentById(int comment_id) {
        return null;
    }

    @Override
    public List<CommentWithPatient> getCommentByArticleIdWithPatient(CommentWithPatient commentWithPatient) {
        return null;
    }

    @Override
    public void insertComment(ArticleComment articleComment) {

    }

    @Override
    public void updateComment(ArticleComment articleComment) {

    }

    @Override
    public void deleteComment(int comment_id) {

    }
}
