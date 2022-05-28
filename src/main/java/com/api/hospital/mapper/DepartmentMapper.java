package com.api.hospital.mapper;

import com.api.hospital.model.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    @Select("select * from department where department_id = #{department_id}")
    Department getDepartmentById(Integer department_id);

    @Select("select * from department")
    List<Department> findDepartmentAll();

    @Options(useGeneratedKeys = true, keyProperty = "department_id", keyColumn = "department_id")
    @Insert("insert into department(department_name) values(#{department_name})")
    int insertDepartment(Department department);

    @Delete("delete from department where department_id = #{department_id}")
    int deleteDepartment(Integer department_id);

    @Update("update department set department_name = #{department_description} where department_id = #{department_id}")
    int updateDepartment(Department department);
}
