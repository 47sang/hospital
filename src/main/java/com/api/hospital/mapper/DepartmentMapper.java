package com.api.hospital.mapper;

import com.api.hospital.model.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    /**
     * 根据科室部门id查询一条科室部门信息
     * @param department_id 科室部门id
     * @return Department 科室部门对象
     */
    @Select("select * from department where department_id = #{department_id}")
    Department getDepartmentById(Integer department_id);

    /**
     * 获取所有科室部门信息
     * @return List<Department> 科室部门对象集合
     */
    @Select("select * from department")
    List<Department> findDepartmentAll();

    /**
     * 插入一条科室部门信息
     * @param department 科室部门对象
     * @return int 1成功 0失败
     */
    @Options(useGeneratedKeys = true, keyProperty = "department_id", keyColumn = "department_id")
    @Insert("insert into department(department_name) values(#{department_name})")
    int insertDepartment(Department department);

    /**
     * 根据科室部门id更新一条科室部门信息
     * @param department_id 科室部门id
     * @return int 1成功 0失败
     */
    @Delete("delete from department where department_id = #{department_id}")
    int deleteDepartment(Integer department_id);

    /**
     * 根据科室部门id更新一条科室部门信息
     * @param department 科室部门对象
     * @return int 1成功 0失败
     */
    @Update("update department set department_name = #{department_description} where department_id = #{department_id}")
    int updateDepartment(Department department);
}
