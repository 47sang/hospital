package com.api.hospital.mapper;

import com.api.hospital.model.entity.Doctor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DoctorMapper {
    /**
     * 插入一条医生信息
     *
     * @param doctor 医生对象
     * @return int 1成功 0失败
     */
    @Options(useGeneratedKeys = true, keyProperty = "doctor_id", keyColumn = "doctor_id")
    @Insert("insert into doctor(doctor_name,doctor_avatar,doctor_title,doctor_specialty,doctor_resume,department_id,clinic_id) " +
            "values(#{doctor_name},#{doctor_avatar},#{doctor_title},#{doctor_specialty},#{doctor_resume},#{department_id},#{clinic_id})")
    int insertDoctor(Doctor doctor);

    /**
     * 根据医生id查询医生信息
     *
     * @param doctorId 医生id
     * @return Doctor 医生对象
     */
    @Select("select * from doctor where doctor_id = #{doctorId}")
    Doctor getDoctorById(int doctorId);

    /**
     * 根据医生姓名查询医生信息
     *
     * @param doctorName 医生姓名
     * @return Doctor 医生对象
     */
    @Select("select * from doctor where doctor_name = #{doctorName}")
    Doctor getDoctorByName(String doctorName);

    /**
     * 根据科室部门id查询医生信息
     *
     * @param departmentId 科室部门id
     * @return List<Doctor> 医生对象列表集合
     */
    @Select("select * from doctor where department_id = #{departmentId}")
    List<Doctor> getDoctorByDepartmentId(int departmentId);

    /**
     * 根据科室门诊id查询医生信息
     *
     * @param clinicId 科室门诊id
     * @return List<Doctor> 医生对象列表集合
     */
    @Select("select * from doctor where clinic_id = #{clinicId}")
    List<Doctor> getDoctorByClinicId(int clinicId);

    /**
     * 根据医生id修改医生信息
     *
     * @param doctor 医生对象
     * @return int 1成功 0失败
     */
    @Update("update doctor set doctor_name = #{doctor_name},doctor_avatar = #{doctor_avatar},doctor_title = #{doctor_title}," +
            "doctor_specialty = #{doctor_specialty},doctor_resume = #{doctor_resume},department_id = #{department_id}," +
            "clinic_id = #{clinic_id} where doctor_id = #{doctor_id}")
    int updateDoctor(Doctor doctor);

    /**
     * 根据医生id删除医生信息
     *
     * @param doctorId 医生id
     * @return int 1成功 0失败
     */
    @Delete("delete from doctor where doctor_id = #{doctorId}")
    int deleteDoctor(int doctorId);
}
