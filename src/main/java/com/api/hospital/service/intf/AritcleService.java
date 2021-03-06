package com.api.hospital.service.intf;


import com.api.hospital.model.entity.Article;
import com.api.hospital.model.vo.Health;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AritcleService {

    Article getArticleById(int article_id);

    void deleteArticleById(int article_id);

    void updateArticleById(Article article);

    void insertArticle(Article article);

    void insertArticle(Article article, MultipartFile file);

    List<Article> getArticles();

    List<Article> getArticlesByPage(int start, int end);

    List<Article> getArticlesByPaging(String article_type, int start, int end);

    List<Article> getArticlesByType(String article_type);

    List<Health> getHealth(int start, int end);

    void updateArticlePraise(int article_id);

    void updateArticlePraiseCancel(int article_id);

}
