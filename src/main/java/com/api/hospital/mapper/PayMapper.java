package com.api.hospital.mapper;

import com.api.hospital.model.entity.Pay;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PayMapper {

    /**
     * 插入一条缴费记录
     *
     * @param pay 缴费对象
     * @return int 1成功 0失败
     */
    @Options(useGeneratedKeys = true, keyProperty = "pay_id", keyColumn = "pay_id")
    @Insert("insert into pay(pay_datetime,pay_money,pay_type,pay_status,patient_id) " +
            "values(#{pay_datetime},#{pay_money},#{pay_type},#{pay_status},#{patient_id})")
    int insertPay(Pay pay);

    /**
     * 根据患者id查询所有缴费记录
     *
     * @param patientId 患者id
     * @return List<Pay> 缴费记录列表集合
     */
    @Select("select * from pay where patient_id=#{patientId} order by pay_id desc")
    List<Pay> selectPayByPatientId(int patientId);

    /**
     * 根据缴费id查询缴费记录
     *
     * @param payId 缴费id
     * @return Pay 缴费对象
     */
    @Select("select * from pay where pay_id=#{payId}")
    Pay selectPayByPayId(int payId);

    /**
     * 根据缴费id修改缴费状态
     * @param payStatus 缴费状态
     * @param payId     缴费id
     * @return int 1成功 0失败
     */
    @Update("update pay set pay_status=#{payStatus} where pay_id=#{payId}")
    int updatePayStatusByPayId(String payStatus, int payId);


}
