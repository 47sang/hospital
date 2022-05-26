package com.api.hospital.controller;

import com.api.hospital.model.entity.Article;
import com.api.hospital.service.intf.AritcleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "首页接口")
@RestController
public class MainController {

    @Resource
    AritcleService aritcleService;

    @ApiOperation(value = "首页id为1的文章")
    @GetMapping("/")
    public Article index() {
        return aritcleService.getArticleById(1);
    }

    @ApiOperation(value = "根据id查询文章")
    @GetMapping("/article/{article_id}")
    public Article article(@PathVariable("article_id") int article_id) {
        return aritcleService.getArticleById(article_id);
    }

    @ApiOperation(value = "添加文章")
    @PostMapping("/")
    public int insertArticle(@ApiParam("文章标题") @RequestParam("article_title") String title,
                                 @ApiParam("文章关键词") @RequestParam("article_keywords") String article_keywords,
                                 @ApiParam("文章内容") @RequestParam("article_content") String article_content,
                                 @ApiParam("作者医生id") @RequestParam("doctor_id") int doctor_id) {
        Article article = new Article();
        article.setArticle_title(title);
        article.setArticle_keywords(article_keywords);
        article.setArticle_content(article_content);
        article.setDoctor_id(doctor_id);

        return aritcleService.insertArticle(article);
    }


}
