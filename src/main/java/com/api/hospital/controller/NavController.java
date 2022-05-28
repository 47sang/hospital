package com.api.hospital.controller;

import com.api.hospital.model.dto.ResponseInfo;
import com.api.hospital.model.entity.Nav;
import com.api.hospital.service.intf.NavService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Api(tags = "导航接口")
@RequestMapping(value = "/nav")
@RestController
public class NavController {
    @Resource
    NavService navService;

    @ApiOperation(value = "获取导航列表")
    @GetMapping({"/", ""})
    public ResponseInfo getNav() {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String, List<Nav>> data = new HashMap<>();
        try {
            data.put("nav", navService.findNavAll());
            responseInfo.setData(data);
        } catch (Exception e) {
            responseInfo.setCode(401);
            responseInfo.setMessage(e.getMessage());
        }

        return responseInfo;
    }

    @ApiOperation(value = "新增导航")
    @PostMapping({"/", ""})
    public ResponseInfo addNav(@ApiParam("导航标题") @RequestParam("nav_title") String nav_title,
                               @ApiParam("导航图标地址") @RequestParam(value = "nav_icon", required = false) String nav_icon,
                               @ApiParam("导航分类") @RequestParam(value = "nav_type", required = false) String nav_type,
                               @ApiParam("导航链接") @RequestParam(value = "nav_url", required = false) String nav_url,
                               @ApiParam("导航排序") @RequestParam(value = "nav_sort", required = false, defaultValue = "1") Integer nav_sort,
                               @ApiParam("导航状态") @RequestParam(value = "nav_status", required = false, defaultValue = "启用") String nav_status) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String, Nav> data = new HashMap<>();
        Nav nav = new Nav();
        if (nav_title == null || nav_title.equals("")) {
            responseInfo.setCode(502);
            responseInfo.setMessage("导航标题不能为空");
            return responseInfo;
        }
        try {
            nav.setNav_title(nav_title);
            nav.setNav_icon(nav_icon);
            nav.setNav_type(nav_type);
            nav.setNav_url(nav_url);
            nav.setNav_status(nav_status);
            nav.setNav_sort(nav_sort);
            navService.addNav(nav);
            data.put("nav", nav);
            responseInfo.setData(data);
        } catch (Exception e) {
            responseInfo.setCode(501);
            responseInfo.setMessage("添加失败");
            log.error(String.valueOf(nav));
        }

        return responseInfo;
    }

    @ApiOperation(value = "修改导航")
    @PutMapping({"/", ""})
    public ResponseInfo update(Nav nav) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String, Nav> data = new HashMap<>();
        try {
            navService.updateNav(nav);
            data.put("nav", nav);
            responseInfo.setData(data);
        } catch (Exception e) {
            responseInfo.setCode(501);
            responseInfo.setMessage("修改失败");
            log.error(String.valueOf(nav));
        }

        return responseInfo;
    }

    @ApiOperation(value = "删除导航")
    @DeleteMapping({"/", ""})
    public ResponseInfo delete(@ApiParam("导航id") @RequestParam("nav_id") Integer nav_id) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String, Nav> data = new HashMap<>();
        try {
            navService.deleteNav(nav_id);
            data.put("nav", new Nav());
            responseInfo.setData(data);
        } catch (Exception e) {
            responseInfo.setCode(501);
            responseInfo.setMessage("删除失败");
            log.error(String.valueOf(nav_id));
        }

        return responseInfo;
    }
}
