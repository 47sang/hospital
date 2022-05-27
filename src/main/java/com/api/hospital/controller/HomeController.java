package com.api.hospital.controller;

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
    public WxHome home() {
        WxHome wxHome = new WxHome();
        wxHome.setNavs(navService.findNavByType("navs"));
        //TODO: 待完善dao层和service层
        wxHome.setNews();
        wxHome.setBanners();
        wxHome.setGeneral();
        wxHome.setDepartments();
        wxHome.setHealthPush();
        return wxHome;
    }

}
