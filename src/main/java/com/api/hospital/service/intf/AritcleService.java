package com.api.hospital.service.intf;


import com.api.hospital.model.entity.Article;
import com.api.hospital.model.entity.Health;

import java.util.List;

public interface AritcleService {

    Article getArticleById(int article_id);

    int deleteArticleById(int article_id);

    int updateArticleById(Article article);

    int insertArticle(Article article);

    Article[] getArticles();

    List<Article> getArticlesByPaging(String article_type, int start, int end);

    List<Article> getArticlesByType(String article_type);

    List<Health> getHealth(int start, int end);

}
