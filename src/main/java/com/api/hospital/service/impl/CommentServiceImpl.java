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
        return articleCommentMapper.getCommentCount(article_id);
    }

    @Override
    public List<ArticleComment> getCommentByArticleId(int article_id) {
        List<ArticleComment> data = articleCommentMapper.getCommentByArticleId(article_id);
        if (data.size() > 0) return data;
        else throw new RuntimeException("此文章没有评论");
    }

    @Override
    public ArticleComment getCommentById(int comment_id) {
        ArticleComment data = articleCommentMapper.getCommentById(comment_id);
        if (data != null) return data;
        else throw new RuntimeException("评论不存在");
    }

    @Override
    public List<CommentWithPatient> getCommentByArticleIdWithPatient(int article_id) {
        List<CommentWithPatient> data = articleCommentMapper.getCommentByArticleIdWithPatient(article_id);
        if (data.size() > 0) return data;
        else throw new RuntimeException("此文章没有评论");
    }

    @Override
    public void insertComment(ArticleComment articleComment) {
        int result = articleCommentMapper.insertComment(articleComment);
        if (result == 1) {
            articleMapper.updateArticleCommentsCount(articleComment.getArticle_id());
        } else throw new RuntimeException("发表评论失败");
    }

    @Override
    public void updateComment(ArticleComment articleComment) {
        int result = articleCommentMapper.updateComment(articleComment);
        if (result != 1) throw new RuntimeException("更新评论失败");
    }

    @Override
    public void deleteComment(int comment_id) {
        int result = articleCommentMapper.deleteComment(comment_id);
        if (result == 1) {
            articleMapper.updateArticleCommentsCountMinus(comment_id);
        } else throw new RuntimeException("删除评论失败");
    }

}
