package com.api.hospital.controller;

import com.api.hospital.model.dto.ResponseInfo;
import com.api.hospital.model.entity.*;
import com.api.hospital.service.intf.AritcleService;
import com.api.hospital.service.intf.CommentService;
import com.api.hospital.service.intf.DoctorService;
import com.api.hospital.service.intf.PraiseAndCollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "文章管理接口")
@RequestMapping(value = "/article")
@RestController
public class AritcleController {
    @Autowired
    private AritcleService aritcleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PraiseAndCollectService praiseAndCollectService;

    @ApiOperation(value = "分页获取文章列表")
    @GetMapping({"/list/{page}", "/list"})
    public ResponseInfo<Map<String, List<Article>>> getAritcleBypage(@PathVariable(value = "page", required = false) Integer page) {
        ResponseInfo<Map<String, List<Article>>> responseInfo = new ResponseInfo();
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
    public ResponseInfo<Map<String, List<Article>>> getAritclesByType(@RequestParam("article_type") String article_type) {
        ResponseInfo<Map<String, List<Article>>> responseInfo = new ResponseInfo();
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
    public ResponseInfo<Map<String, Object>> articleById(@PathVariable("article_id") int article_id) {
        ResponseInfo<Map<String, Object>> responseInfo = new ResponseInfo();
        Map<String, Object> data = new HashMap<>();
        try {
            Article article = aritcleService.getArticleById(article_id);
            List<CommentWithPatient> comment = commentService.getCommentByArticleIdWithPatient(article_id);
            Doctor doctor = doctorService.getDoctorById(article.getDoctor_id());
            data.put("article", article);
            data.put("comment", comment);
            data.put("doctor", doctor);
            responseInfo.setData(data);
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
    public ResponseInfo<Article> insertArticle(Article article, @RequestParam(value = "file", required = false) MultipartFile file) {
        ResponseInfo<Article> responseInfo = new ResponseInfo();
        try {
            if (file == null) {
                aritcleService.insertArticle(article);
            } else {
                aritcleService.insertArticle(article, file);
            }
            responseInfo.setData(article);
        } catch (Exception e) {
            responseInfo.setCode(501);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation(value = "更新文章")
    @PutMapping("")
    public ResponseInfo<Article> updateArticle(Article article) {
        ResponseInfo<Article> responseInfo = new ResponseInfo();
        try {
            aritcleService.updateArticleById(article);
            responseInfo.setData(article);
        } catch (Exception e) {
            responseInfo.setCode(501);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation(value = "发布评论")
    @PostMapping("/comment")
    public ResponseInfo<ArticleComment> insertComment(ArticleComment comment) {
        ResponseInfo<ArticleComment> responseInfo = new ResponseInfo();
        try {
            commentService.insertComment(comment);
            responseInfo.setData(comment);
        } catch (Exception e) {
            responseInfo.setCode(501);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation(value = "文章点赞")
    @GetMapping("/praise")
    public ResponseInfo<Praise> likeArticle(@RequestParam("article_id") Praise praise) {
        ResponseInfo<Praise> responseInfo = new ResponseInfo();
        try {
            praiseAndCollectService.insertPraise(praise);
        } catch (Exception e) {
            responseInfo.setCode(501);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation(value = "取消文章点赞")
    @DeleteMapping("/praise")
    public ResponseInfo<Praise> unlikeArticle(@RequestParam("article_id") Praise praise) {
        ResponseInfo<Praise> responseInfo = new ResponseInfo();
        try {
            praiseAndCollectService.deletePraise(praise);
        } catch (Exception e) {
            responseInfo.setCode(501);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }
    @ApiOperation(value = "文章收藏")
    @GetMapping("/collect")
    public ResponseInfo<Collect> collectArticle(@RequestParam("article_id") Collect collect) {
        ResponseInfo<Collect> responseInfo = new ResponseInfo();
        try {
            praiseAndCollectService.insertCollect(collect);
        } catch (Exception e) {
            responseInfo.setCode(501);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation(value = "取消文章收藏")
    @DeleteMapping("/collect")
    public ResponseInfo<Collect> uncollectArticle(@RequestParam("article_id") Collect collect) {
        ResponseInfo<Collect> responseInfo = new ResponseInfo();
        try {
            praiseAndCollectService.deleteCollect(collect);
        } catch (Exception e) {
            responseInfo.setCode(501);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }
}
