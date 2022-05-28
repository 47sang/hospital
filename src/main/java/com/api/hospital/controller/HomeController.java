package com.api.hospital.controller;

import com.api.hospital.model.dto.ResponseInfo;
import com.api.hospital.model.vo.WxHome;
import com.api.hospital.service.intf.AritcleService;
import com.api.hospital.service.intf.DepartmentService;
import com.api.hospital.service.intf.NavService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "微信小程序接口")
@RestController
public class HomeController {

    @Resource
    private AritcleService aritcleService;

    @Resource
    private NavService navService;

    @Resource
    private DepartmentService departmentService;


    @GetMapping("/home")
    public ResponseInfo home() {
        ResponseInfo responseInfo = new ResponseInfo();

        WxHome wxHome = new WxHome();
        try {
            //填充数据
            wxHome.setNavs(navService.findNavByType("navs"));
            wxHome.setHeadlines(aritcleService.getArticlesByType("最头条"));
            wxHome.setBanners(aritcleService.getArticlesByType("banner"));
            wxHome.setGeneral(navService.findNavByType("门诊服务"));
            wxHome.setDepartments(departmentService.findDepartmentAll());
            wxHome.setHealthPush(aritcleService.getArticlesByPaging("健康推送", 0, 3));
            responseInfo.setData(wxHome);
        } catch (Exception e) {
            responseInfo.setCode(500);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

}
