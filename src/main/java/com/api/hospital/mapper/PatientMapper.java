package com.api.hospital.mapper;

import com.api.hospital.model.entity.Patient;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PatientMapper {

    /**
     * 插入一条患者信息
     * @param patient 患者对象
     * @return int 1成功 0失败
     */
    @Insert("insert into patient(patient_name,patient_card_id,patient_born_date,patient_sex,patient_phone,patient_medical_card,patient_avatar) " +
            "values(#{patient_name},#{patient_card_id},#{patient_born_date},#{patient_sex},#{patient_phone},#{patient_medical_card},#{patient_avatar})")
    int insertPatient(Patient patient);

    /**
     * 根据患者id查找患者信息
     * @param patientId 患者id
     * @return Patient 患者对象
     */
    @Select("select * from patient where patient_id = #{patientId}")
    Patient getPatientById(int patientId);

    /**
     * 根据患者手机号查找患者信息
     * @param patientPhone 患者手机号
     * @return Patient 患者对象
     */
    @Select("select * from patient where patient_phone = #{patientPhone}")
    Patient getPatientByPhone(int patientPhone);

    /**
     * 根据患者身份证号查找患者信息
     * @param patientCardId 患者身份证号
     * @return Patient 患者对象
     */
    @Select("select * from patient where patient_card_id = #{patientCardId}")
    Patient getPatientByCardId(int patientCardId);

    /**
     * 根据患者就诊卡号查找患者信息
     * @param patientMedicalCard 患者就诊卡号
     * @return Patient 患者对象
     */
    @Select("select * from patient where patient_medical_card = #{patientMedicalCard}")
    Patient getPatientByMedicalCard(int patientMedicalCard);

    /**
     * 根据患者id更新患者信息
     * @param patient 患者对象
     * @return int 1成功 0失败
     */
    @Update("update patient set patient_name=#{patient_name},patient_card_id=#{patient_card_id},patient_born_date=#{patient_born_date}," +
            "patient_sex=#{patient_sex},patient_phone=#{patient_phone},patient_medical_card=#{patient_medical_card},patient_avatar=#{patient_avatar} " +
            "where patient_id=#{patient_id}")
    int updatePatient(Patient patient);

    /**
     * 根据患者id删除患者信息
     * @param patientId 患者id
     * @return int 1成功 0失败
     */
    @Delete("delete from patient where patient_id = #{patientId}")
    int deletePatient(int patientId);

}
