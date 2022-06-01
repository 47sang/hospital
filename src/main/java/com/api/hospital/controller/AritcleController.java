package com.api.hospital.controller;

import com.api.hospital.model.dto.ResponseInfo;
import com.api.hospital.model.entity.Article;
import com.api.hospital.service.intf.AritcleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "文章管理接口")
@RequestMapping(value = "/article")
@RestController
public class AritcleController {
    @Autowired
    private AritcleService aritcleService;

    @ApiOperation(value = "分页获取文章列表")
    @GetMapping({"/list/{page}", "/list"})
    public ResponseInfo getAritcleBypage(@PathVariable(value = "page", required = false) Integer page) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String, List<Article>> data = new HashMap<>();
        if (page == null) {
            page = 0;
        } else {
            page = page * 10;
        }
        try {
            data.put("article", aritcleService.getArticlesByPage(page, 10));
            responseInfo.setData(data);
        } catch (Exception e) {
            responseInfo.setCode(500);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation(value = "根据分类获取列表")
    @GetMapping("")
    public ResponseInfo getAritclesByType(@RequestParam("article_type") String article_type) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String, List<Article>> data = new HashMap<>();
        try {
            data.put("article", aritcleService.getArticlesByType(article_type));
            responseInfo.setData(data);
        } catch (Exception e) {
            responseInfo.setCode(500);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation(value = "根据id查询文章")
    @GetMapping("/{article_id}")
    public ResponseInfo articleById(@PathVariable("article_id") int article_id) {
        ResponseInfo responseInfo = new ResponseInfo();
        try {
            Article article = aritcleService.getArticleById(article_id);
            responseInfo.setData(article);
        } catch (Exception e) {
            responseInfo.setCode(400);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation(value = "根据id删除文章")
    @DeleteMapping("")
    public ResponseInfo deleteArticle(@RequestParam("article_id") int article_id) {
        ResponseInfo responseInfo = new ResponseInfo();
        try {
            aritcleService.deleteArticleById(article_id);
        } catch (Exception e) {
            responseInfo.setCode(400);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation(value = "添加文章")
    @PostMapping("")
    public ResponseInfo insertArticle(Article article) {
        ResponseInfo responseInfo = new ResponseInfo();
        try {
            aritcleService.insertArticle(article);
            responseInfo.setData(article);
        } catch (Exception e) {
            responseInfo.setCode(501);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation(value = "更新文章")
    @PutMapping("")
    public ResponseInfo updateArticle(Article article) {
        ResponseInfo responseInfo = new ResponseInfo();
        try {
            aritcleService.updateArticleById(article);
            responseInfo.setData(article);
        } catch (Exception e) {
            responseInfo.setCode(501);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

}
