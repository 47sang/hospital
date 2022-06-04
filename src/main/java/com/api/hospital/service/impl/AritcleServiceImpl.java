package com.api.hospital.service.impl;

import com.api.hospital.constant.ExceptionConstants;
import com.api.hospital.mapper.ArticleCommentMapper;
import com.api.hospital.mapper.ArticleMapper;
import com.api.hospital.model.entity.Article;
import com.api.hospital.model.vo.Health;
import com.api.hospital.service.intf.AritcleService;
import com.api.hospital.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class AritcleServiceImpl implements AritcleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleCommentMapper articleCommentMapper;

    @Value("${file.path}")
    String uploadPath;

    @Override
    public Article getArticleById(int article_id) {
        Article data = articleMapper.getArticleById(article_id);
        if (data != null) {
            articleMapper.updateArticleViews(article_id);
            data.setArticle_views(data.getArticle_views() + 1);
            return data;
        } else {
            throw new RuntimeException(ExceptionConstants.DATA_READ_FAIL_MSG);
        }
    }

    @Override
    public void deleteArticleById(int article_id) {
        int result = articleMapper.deleteArticleById(article_id);
        if (result == 1) {
            articleCommentMapper.deleteCommentByArticleId(article_id);
        } else {
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public void updateArticleById(Article article) {
        int result = articleMapper.updateArticleById(article);
        if (result != 1) {
            throw new RuntimeException("更新失败");
        }
    }

     @Override
    public void insertArticle(Article article) {
        int result = articleMapper.insertArticle(article);
        if (result != 1) {
            throw new RuntimeException("插入失败");
        }
    }

    @Override
    public void insertArticle(Article article, MultipartFile file) {
        String img = new FileUtils().uploadImg(file,uploadPath);
        article.setArticle_pic(img);
        int result = articleMapper.insertArticle(article);
        if (result != 1) {
            throw new RuntimeException("插入失败");
        }
    }

    @Override
    public List<Article> getArticles() {
        List<Article> data = articleMapper.getArticles();
        if (data.size() > 0) {
            return data;
        } else {
            throw new RuntimeException("没有数据了");
        }
    }

    @Override
    public List<Article> getArticlesByPage(int start, int end) {
        List<Article> data = articleMapper.getArticlesByPage(start, end);
        if (data.size() > 0) {
            return data;
        } else {
            throw new RuntimeException("没有数据了");
        }
    }

    @Override
    public List<Article> getArticlesByPaging(String article_type, int start, int end) {
        List<Article> data = articleMapper.getArticlesByPaging(article_type, start, end);
        if (data.size() > 0) {
            return data;
        } else {
            throw new RuntimeException("没有数据了");
        }
    }

    @Override
    public List<Article> getArticlesByType(String article_type) {
        List<Article> data = articleMapper.getArticlesByType(article_type);
        if (data.size() > 0) {
            return data;
        } else {
            throw new RuntimeException("没有数据了");
        }
    }

    @Override
    public List<Health> getHealth(int start, int end) {
        List<Health> healths = articleMapper.getHealth(start, end);
        if (healths.size() > 0) {
            return articleMapper.getHealth(start, end);
        } else {
            throw new RuntimeException("没有数据了");
        }

    }

    @Override
    public void updateArticlePraise(int article_id) {
        int result = articleMapper.updateArticlePraise(article_id);
        if (result != 1) {
            throw new RuntimeException("文章点赞失败");
        }
    }

    @Override
    public void updateArticlePraiseCancel(int article_id) {
        int result = articleMapper.updateArticlePraiseCancel(article_id);
        if (result != 1) {
            throw new RuntimeException("取消文章点赞失败");
        }
    }
}
