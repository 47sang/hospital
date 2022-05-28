package com.api.hospital.controller;

import com.api.hospital.model.dto.ResponseInfo;
import com.api.hospital.service.intf.AritcleService;
import com.api.hospital.service.intf.NavService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Api(tags = "demo接口")
@RestController
public class MainController {

    @Resource
    private AritcleService aritcleService;

    @Resource
    private NavService navService;

    @Value("${file.path}")
    private String uploadPath;



    @PostMapping(value = "/upload")
    @ApiOperation(value = "文件上传")
    public ResponseInfo upload(@RequestParam("file") MultipartFile file) {
        ResponseInfo responseInfo = new ResponseInfo();
        try {
            String fileName = navService.uploadIcon(file);
            responseInfo.setData(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            responseInfo.setCode(400);
            responseInfo.setMessage("上传失败");
        }
        return responseInfo;
    }
}
