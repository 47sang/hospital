package com.api.hospital.controller;

import com.api.hospital.model.dto.ResponseInfo;
import com.api.hospital.model.vo.WxHome;
import com.api.hospital.service.intf.AritcleService;
import com.api.hospital.service.intf.NavService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "微信小程序首页-Home")
@RestController
public class HomeController {

    @Resource
    AritcleService aritcleService;

    @Resource
    NavService navService;


    @GetMapping("/home")
    public ResponseInfo home() {
        ResponseInfo responseInfo = new ResponseInfo();

        WxHome wxHome = new WxHome();
        wxHome.setNavs(navService.findNavByType("navs"));
        //TODO: 待完善dao层和service层
        wxHome.setHeadlines(aritcleService.getArticlesByType("最头条"));
        wxHome.setBanners(aritcleService.getArticlesByType("banner"));
//        wxHome.setGeneral();
//        wxHome.setDepartments();
        wxHome.setHealthPush(aritcleService.getArticlesByTypeInStartAndEnd("健康推送",0,3));

        responseInfo.setData(wxHome);

        return responseInfo;
    }

}
