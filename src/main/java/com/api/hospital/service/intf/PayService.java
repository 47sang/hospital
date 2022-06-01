package com.api.hospital.service.intf;

import com.api.hospital.model.entity.Pay;

import java.util.List;

public interface PayService {
    void insertPay(Pay pay);

    List<Pay> selectPayByPatientId(int patientId);

    Pay selectPayByPayId(int payId);

    void updatePayStatusByPayId(String payStatus, int payId);
}
