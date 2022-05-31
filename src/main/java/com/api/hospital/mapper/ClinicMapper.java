package com.api.hospital.mapper;

import com.api.hospital.model.entity.Clinic;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClinicMapper {
    /**
     * 根据科室门诊id查询信息
     * @param clinic_id 科室门诊id
     * @return Clinic 科室门诊对象
     */
    @Select("select * from clinic where clinic_id = #{clinic_id}")
    Clinic getClinicById(int clinic_id);

    /**
     * 根据科室部门id查询所有科室门诊信息
     * @param department_id 科室部门id
     * @return List<Clinic> 科室门诊对象集合
     */
    @Select("select * from clinic where department_id = #{department_id}")
    List<Clinic> getClinicByDepartmentId(int department_id);

    /**
     * 获取所有科室门诊信息
     * @return List<Clinic> 科室门诊对象集合
     */
    @Select("select * from clinic")
    List<Clinic> getClinics();

    /**
     * 根据科室门诊id更新一条科室门诊信息
     * @param clinic 科室门诊对象
     * @return int 1成功 0失败
     */
    @Update("update clinic set clinic_name = #{clinic_name}, department_id = #{department_id} where clinic_id = #{clinic_id}")
    int updateClinic(Clinic clinic);

    /**
     * 插入一条科室门诊信息
     * @param clinic 科室门诊对象
     * @return int 1成功 0失败
     */
    @Insert("insert into clinic(clinic_name, department_id) values(#{clinic_name}, #{department_id})")
    int insertClinic(Clinic clinic);

    /**
     * 根据科室门诊id删除一条科室门诊信息
     * @param clinic_id 科室门诊id
     * @return int 1成功 0失败
     */
    @Delete("delete from clinic where clinic_id = #{clinic_id}")
    int deleteClinic(int clinic_id);
}
