package com.api.hospital.service.intf;

import com.api.hospital.model.entity.Reservation;

import java.util.List;

public interface ReservationService {
    void insertReservation(Reservation reservation);

    List<Reservation> selectReservationByPatientId(int patientId);

    List<Reservation> selectReservationByDoctorId(int doctorId);
}
