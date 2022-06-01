package com.api.hospital.service.impl;

import com.api.hospital.mapper.ReservationMapper;
import com.api.hospital.model.entity.Reservation;
import com.api.hospital.service.intf.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    public void insertReservation(Reservation reservation) {
        int result = reservationMapper.insertReservation(reservation);
        if (result != 1) {
            throw new RuntimeException("插入预约记录失败");
        }

    }

    @Override
    public List<Reservation> selectReservationByPatientId(int patientId) {
        List<Reservation> reservations = reservationMapper.selectReservationByPatientId(patientId);
        if (reservations.size() > 0) {
            return reservations;
        } else {
            throw new RuntimeException("查询预约记录为0");
        }
    }

    @Override
    public List<Reservation> selectReservationByDoctorId(int doctorId) {
        List<Reservation> reservations = reservationMapper.selectReservationByDoctorId(doctorId);
        if (reservations.size() > 0) {
            return reservations;
        } else {
            throw new RuntimeException("查询预约记录为0");
        }
    }


    //todo: 按天查询预约记录，排除今天之前的预约记录

}
