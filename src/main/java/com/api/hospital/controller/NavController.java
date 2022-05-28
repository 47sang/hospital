package com.api.hospital.controller;

import com.api.hospital.model.dto.ResponseInfo;
import com.api.hospital.model.entity.Nav;
import com.api.hospital.service.intf.NavService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    private NavService navService;

    @ApiOperation(value = "根据id获取导航")
    @GetMapping("{nav_id}")
    public ResponseInfo findNavById(@PathVariable("nav_id") Integer nav_id) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String, Nav> data = new HashMap<>();
        try {
            data.put("nav", navService.findNavById(nav_id));
            responseInfo.setData(data);
        } catch (Exception e) {
            responseInfo.setCode(401);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation(value = "获取导航列表")
    @GetMapping("")
    public ResponseInfo findNavAll() {
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
    @PostMapping("")
    public ResponseInfo newNav(Nav nav, @RequestParam(value = "file", required = false) MultipartFile file) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String, Nav> data = new HashMap<>();
        try {
            //判断是否上传了文件
            if (file != null) {
                String icon = navService.uploadIcon(file);
                nav.setNav_icon(icon);
            }
            navService.addNav(nav);
            data.put("nav", nav);
            responseInfo.setData(data);
        } catch (Exception e) {
            responseInfo.setCode(501);
            responseInfo.setMessage(e.getMessage());
//            log.error(String.valueOf(nav));
        }
        return responseInfo;
    }

    @ApiOperation(value = "修改导航")
    @PutMapping("")
    public ResponseInfo updateNav(Nav nav) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String, Nav> data = new HashMap<>();
        try {
            navService.updateNav(nav);
            data.put("nav", nav);
            responseInfo.setData(data);
        } catch (Exception e) {
            responseInfo.setCode(501);
            responseInfo.setMessage(e.getMessage());
//            log.error(String.valueOf(nav));
        }
        return responseInfo;
    }

    @ApiOperation(value = "删除导航")
    @DeleteMapping("")
    public ResponseInfo deleteNav(@ApiParam("导航id") @RequestParam("nav_id") Integer nav_id) {
        ResponseInfo responseInfo = new ResponseInfo();
        try {
            navService.deleteNav(nav_id);
        } catch (Exception e) {
            responseInfo.setCode(401);
            responseInfo.setMessage(e.getMessage());
//            log.error(String.valueOf(nav_id));
        }
        return responseInfo;
    }
}
