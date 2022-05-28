package com.api.hospital.controller;

import com.api.hospital.model.dto.ResponseInfo;
import com.api.hospital.model.vo.Health;
import com.api.hospital.model.vo.WxHealth;
import com.api.hospital.model.vo.WxHome;
import com.api.hospital.service.intf.AritcleService;
import com.api.hospital.service.intf.DepartmentService;
import com.api.hospital.service.intf.NavService;
import com.api.hospital.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Api(tags = "微信小程序接口")
@RestController
public class HomeController {

    @Resource
    private AritcleService aritcleService;

    @Resource
    private NavService navService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @Resource
    RedisUtils redisUtils;

    @ApiOperation(value = "首页数据")
    @GetMapping("/home")
    public ResponseInfo home() {
        ResponseInfo responseInfo = new ResponseInfo();
        WxHome wxHome = new WxHome();
        //从redis中获取数据
        if (redisTemplate.hasKey("home")) {
            wxHome = (WxHome) redisUtils.get("home");
            responseInfo.setData(wxHome);
        } else {
            try {
                //填充数据
                wxHome.setNavs(navService.findNavByType("navs"));
                wxHome.setHeadlines(aritcleService.getArticlesByType("最头条"));
                wxHome.setBanners(aritcleService.getArticlesByType("banner"));
                wxHome.setGeneral(navService.findNavByType("门诊服务"));
                wxHome.setDepartments(departmentService.findDepartmentAll());
                wxHome.setHealthPush(aritcleService.getArticlesByPaging("健康推送", 0, 3));
                responseInfo.setData(wxHome);
                //存入redis并设置过期时间
                redisUtils.set("home", wxHome);
                redisTemplate.expire("home", 5, TimeUnit.MINUTES);
            } catch (Exception e) {
                responseInfo.setCode(500);
                responseInfo.setMessage(e.getMessage());
            }
        }
        return responseInfo;
    }

    @ApiOperation(value = "分页获取健康圈文章数据")
    @GetMapping({"/health/{page}", "/health"})
    public ResponseInfo health(@PathVariable(value = "page", required = false) Integer page) {
        ResponseInfo responseInfo = new ResponseInfo();
        WxHealth wxHealth = new WxHealth();
        if (page == null) {
            page = 0;
        } else {
            page = page * 10;
        }
        if (redisTemplate.hasKey("health" + page)) {
            wxHealth = (WxHealth) redisUtils.get("health" + page);
            responseInfo.setData(wxHealth);
        } else {
            try {
                //填充数据
                List<Health> data = aritcleService.getHealth(page, 10);
                wxHealth.setHealth(data);
                responseInfo.setData(wxHealth);

                //存入redis并设置过期时间
//                redisTemplate.opsForValue().set("health" + page, wxHealth);
                redisUtils.set("health" + page, wxHealth);
                redisTemplate.expire("health" + page, 5, TimeUnit.MINUTES);
            } catch (Exception e) {
                responseInfo.setCode(402);
                responseInfo.setMessage(e.getMessage());
            }
        }
        return responseInfo;
    }
}
