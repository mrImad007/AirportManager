package com.app.airportmanager.DAO;

import com.app.airportmanager.Entities.ReservationExtra;

import java.sql.ResultSet;

public interface ReservationExtraDao {
    boolean add_extra(ReservationExtra reservationExtra);
    ResultSet getTotalAmount();
}
