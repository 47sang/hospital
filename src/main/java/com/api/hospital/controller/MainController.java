package com.api.hospital.controller;

import com.api.hospital.model.dto.ResponseInfo;
import com.api.hospital.model.entity.Article;
import com.api.hospital.service.intf.AritcleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "首页接口")
@RestController
public class MainController {

    @Resource
    AritcleService aritcleService;

    @Value("${file.path}")
    private String uploadPath;

    @ApiOperation(value = "首页id为1的文章")
    @GetMapping("/")
    public Article index() {
        return aritcleService.getArticleById(1);
    }

    @ApiOperation(value = "根据id查询文章")
    @GetMapping("/article/{article_id}")
    public ResponseInfo article(@PathVariable("article_id") int article_id) {
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

    @GetMapping("/hello")
    public ResponseInfo hello() {
        ResponseInfo responseInfo = new ResponseInfo();

        try {
            Article article = aritcleService.getArticleById(1);
            responseInfo.setData(article);
        } catch (Exception e) {
            e.printStackTrace();
            responseInfo.setCode(400);
            responseInfo.setMessage("没有数据");
        }
        return responseInfo;
    }

    @GetMapping("/list")
    public ResponseInfo list() {
        ResponseInfo responseInfo = new ResponseInfo();
        try {
            Article[] article = aritcleService.getArticles();
            responseInfo.setData(article);
        } catch (Exception e) {
            e.printStackTrace();
            responseInfo.setCode(400);
            responseInfo.setMessage("没有数据");
        }
        return responseInfo;
    }

    @GetMapping("/list2")
    public ResponseInfo list2() {
        ResponseInfo responseInfo = new ResponseInfo();
        try {
            Article[] article = aritcleService.getArticles();
            Map<String, Object> data = new HashMap<>();
            data.put("article", article);
            responseInfo.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            responseInfo.setCode(400);
            responseInfo.setMessage("没有数据");
        }
        return responseInfo;
    }


    @PostMapping(value = "/upload")
    @ApiOperation(value = "文件上传")
    public ResponseInfo upload(@RequestParam("file") MultipartFile file) {
        ResponseInfo responseInfo = new ResponseInfo();
        try {
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String path = uploadPath + fileName;
            File dest = new File(path);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            file.transferTo(dest);
            responseInfo.setData(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            responseInfo.setCode(400);
            responseInfo.setMessage("上传失败");
        }
        return responseInfo;
    }
}
