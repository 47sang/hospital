package com.api.hospital.service.impl;

import com.api.hospital.mapper.ArticleMapper;
import com.api.hospital.model.entity.Article;
import com.api.hospital.service.intf.AritcleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AritcleServiceImpl implements AritcleService {

    @Resource
    ArticleMapper articleMapper;

    @Override
    public Article getArticleById(int article_id) {
        Article data = articleMapper.getArticleById(article_id);
        if (data == null) {
            throw new RuntimeException("没有找到对应的文章");
        }else {
            return data;
        }
    }

    @Override
    public int deleteArticleById(int article_id) {
        return articleMapper.deleteArticleById(article_id);
    }

    @Override
    public int updateArticleById(Article article) {
        return articleMapper.updateArticleById(article);
    }

    @Override
    public int insertArticle(Article article) {
        return articleMapper.insertArticle(article);
    }

    @Override
    public Article[] getArticles() {
        return articleMapper.getArticles();
    }
}
