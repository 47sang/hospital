package com.api.hospital.service.impl;

import com.api.hospital.mapper.DepartmentMapper;
import com.api.hospital.model.entity.Department;
import com.api.hospital.service.intf.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    DepartmentMapper departmentMapper;

    @Override
    public Department getDepartmentById(Integer department_id) {
        Department data = departmentMapper.getDepartmentById(department_id);
        if (data != null) return data;
        else throw new RuntimeException("没有找到该科室");
    }

    @Override
    public List<Department> findDepartmentAll() {
        List<Department> data = departmentMapper.findDepartmentAll();
        if (data.size() > 0) return data;
        else throw new RuntimeException("没有任何科室数据");
    }

    @Override
    public void insertDepartment(Department department) {
        if (department.getDepartment_name() == null || department.getDepartment_name().equals("")) throw new RuntimeException("科室名称不能为空");
        int data = departmentMapper.insertDepartment(department);
        if (data != 1) throw new RuntimeException("插入数据失败");
    }

    @Override
    public void deleteDepartment(Integer department_id) {
        int data = departmentMapper.deleteDepartment(department_id);
        if (data != 1) throw new RuntimeException("删除数据失败");
    }

    @Override
    public void updateDepartment(Department department) {
        if (department.getDepartment_name() == null || department.getDepartment_name().equals("")) throw new RuntimeException("科室名称不能为空");
        int data = departmentMapper.updateDepartment(department);
        if (data != 1) throw new RuntimeException("更新数据失败");
    }
}
