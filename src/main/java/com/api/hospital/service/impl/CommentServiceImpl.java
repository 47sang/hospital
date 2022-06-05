package com.api.hospital.service.impl;

import com.api.hospital.mapper.ArticleCommentMapper;
import com.api.hospital.mapper.ArticleMapper;
import com.api.hospital.model.entity.ArticleComment;
import com.api.hospital.model.entity.CommentWithPatient;
import com.api.hospital.service.intf.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ArticleCommentMapper articleCommentMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int getCommentCount(int articleId) {
        return articleCommentMapper.getCommentCount(articleId);
    }

    @Override
    public List<ArticleComment> getCommentByArticleId(int articleId) {
        List<ArticleComment> data = articleCommentMapper.getCommentByArticleId(articleId);
        if (data.size() > 0) {
            return data;
        } else {
            return null;
        }
    }

    @Override
    public ArticleComment getCommentById(int commentId) {
        ArticleComment data = articleCommentMapper.getCommentById(commentId);
        if (data != null) {
            return data;
        } else {
            throw new RuntimeException("评论不存在");
        }
    }

    @Override
    public List<CommentWithPatient> getCommentByArticleIdWithPatient(int articleId) {
        List<CommentWithPatient> data = articleCommentMapper.getCommentByArticleIdWithPatient(articleId);
        if (data.size() > 0) {
            return data;
        } else {
            return null;
        }
    }

    @Override
    public void insertComment(ArticleComment articleComment) {
        int result = articleCommentMapper.insertComment(articleComment);
        if (result == 1) {
            articleMapper.updateArticleCommentsCount(articleComment.getArticle_id());
        } else {
            throw new RuntimeException("发表评论失败");
        }
    }

    @Override
    public void updateComment(ArticleComment articleComment) {
        int result = articleCommentMapper.updateComment(articleComment);
        if (result != 1) {
            throw new RuntimeException("更新评论失败");
        }
    }

    @Override
    public void deleteComment(int commentId) {
        int result = articleCommentMapper.deleteComment(commentId);
        if (result == 1) {
            articleMapper.updateArticleCommentsCountMinus(commentId);
        } else {
            throw new RuntimeException("删除评论失败");
        }
    }

}
