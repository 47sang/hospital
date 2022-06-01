package com.api.hospital.service.impl;

import com.api.hospital.mapper.PayMapper;
import com.api.hospital.model.entity.Pay;
import com.api.hospital.service.intf.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private PayMapper payMapper;

    @Override
    public void insertPay(Pay pay) {
        int result = payMapper.insertPay(pay);
        if (result != 1) {
            throw new RuntimeException("插入缴费信息失败");
        }
    }

    @Override
    public List<Pay> selectPayByPatientId(int patientId) {
        List<Pay> data = payMapper.selectPayByPatientId(patientId);
        if (data.size() > 0) {
            return data;
        } else {
            throw new RuntimeException("没有任何缴费信息");
        }
    }

    @Override
    public Pay selectPayByPayId(int payId) {
        Pay data = payMapper.selectPayByPayId(payId);
        if (data != null) {
            return data;
        } else {
            throw new RuntimeException("没有找到对应的缴费信息");
        }
    }

    @Override
    public void updatePayStatusByPayId(String payStatus, int payId) {
        int result = payMapper.updatePayStatusByPayId(payStatus, payId);
        if (result != 1) {
            throw new RuntimeException("更新缴费信息失败");
        }
    }
}
