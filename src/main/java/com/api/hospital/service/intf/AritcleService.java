package com.api.hospital.service.intf;


import com.api.hospital.model.entity.Article;

public interface AritcleService {

    Article getArticleById(int article_id);

    int deleteArticleById(int article_id);

    int updateArticleById(Article article);

    int insertArticle(Article article);

}
