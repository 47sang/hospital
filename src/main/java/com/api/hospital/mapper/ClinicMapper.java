package com.api.hospital.mapper;

import com.api.hospital.model.entity.Clinic;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClinicMapper {
    @Select("select * from clinic where clinic_id = #{clinic_id}")
    Clinic getClinicById(int clinic_id);

    @Select("select * from clinic where department_id = #{department_id}")
    List<Clinic> getClinicByDepartmentId(int department_id);

    @Select("select * from clinic")
    List<Clinic> getClinics();

    @Update("update clinic set clinic_name = #{clinic_name}, department_id = #{department_id} where clinic_id = #{clinic_id}")
    int updateClinic(Clinic clinic);

    @Insert("insert into clinic(clinic_name, department_id) values(#{clinic_name}, #{department_id})")
    int insertClinic(Clinic clinic);

    @Delete("delete from clinic where clinic_id = #{clinic_id}")
    int deleteClinic(int clinic_id);
}
