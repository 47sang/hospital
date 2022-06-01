package com.api.hospital.mapper;

import com.api.hospital.model.entity.Reservation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReservationMapper {
    /**
     * 插入一条预约记录
     *
     * @param reservation 预约对象
     * @return int 1成功 0失败
     */
    @Insert("insert into reservation(patient_id,doctor_id,department_id,clinic_id,datetime,serial_number) " +
            "values(#{patient_id},#{doctor_id},#{department_id},#{clinic_id},#{datetime},#{serial_number})")
    int insertReservation(Reservation reservation);

    /**
     * 根据患者id查询预约记录
     *
     * @param patientId 患者id
     * @return List<Reservation> 预约记录对象列表
     */
    @Select("select * from reservation where patient_id=#{patientId} order by datetime desc")
    List<Reservation> selectReservationByPatientId(int patientId);

    /**
     * 根据医生id查询预约记录
     *
     * @param doctorId 医生id
     * @return List<Reservation> 预约记录对象列表
     */
    @Select("select * from reservation where doctor_id=#{doctorId}")
    List<Reservation> selectReservationByDoctorId(int doctorId);


}
