package com.api.hospital.controller;

import com.api.hospital.model.dto.ResponseInfo;
import com.api.hospital.model.entity.Department;
import com.api.hospital.service.intf.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "科室部门接口")
@RequestMapping(value = "/dep")
@RestController
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @ApiOperation(value = "查询科室列表")
    @GetMapping(value = "")
    public ResponseInfo findDepartmentAll() {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String, List<Department>> data = new HashMap<>();
        try {
            data.put("department", departmentService.findDepartmentAll());
            responseInfo.setData(data);
        } catch (Exception e) {
            responseInfo.setCode(401);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation(value = "根据ID查询科室列表")
    @GetMapping(value = "/{department_id}")
    public ResponseInfo getDepartmentById(@PathVariable("department_id") Integer department_id) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String, Department> data = new HashMap<>();
        try {
            data.put("department", departmentService.getDepartmentById(department_id));
            responseInfo.setData(data);
        } catch (Exception e) {
            responseInfo.setCode(401);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }


    @ApiOperation(value = "插入科室信息")
    @PostMapping(value = "")
    public ResponseInfo insertDepartment(Department department) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String, Department> data = new HashMap<>();
        try {
            departmentService.insertDepartment(department);
            data.put("department", department);
            responseInfo.setData(data);
        } catch (Exception e) {
            responseInfo.setCode(401);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation(value = "更新科室信息")
    @PutMapping(value = "")
    public ResponseInfo updateDepartment(Department department) {
        ResponseInfo responseInfo = new ResponseInfo();
        Map<String, Department> data = new HashMap<>();
        try {
            departmentService.updateDepartment(department);
            data.put("department", department);
            responseInfo.setData(data);
        } catch (Exception e) {
            responseInfo.setCode(401);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }

    @ApiOperation(value = "删除科室信息")
    @DeleteMapping(value = "")
    public ResponseInfo deleteDepartment(Integer department_id) {
        ResponseInfo responseInfo = new ResponseInfo();
        try {
            departmentService.deleteDepartment(department_id);
        } catch (Exception e) {
            responseInfo.setCode(401);
            responseInfo.setMessage(e.getMessage());
        }
        return responseInfo;
    }
}
