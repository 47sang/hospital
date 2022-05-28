package com.api.hospital.service.intf;

import com.api.hospital.model.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department getDepartmentById(Integer department_id);

    List<Department> findDepartmentAll();

    void insertDepartment(Department department);

    void deleteDepartment(Integer department_id);

    void updateDepartment(Department department);
}
