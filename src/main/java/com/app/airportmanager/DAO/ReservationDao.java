package com.app.airportmanager.DAO;

import com.app.airportmanager.Entities.Reservation;

import java.sql.ResultSet;

public interface ReservationDao {
    boolean create_reservation(Reservation reservation);
    boolean update_reservation(Reservation reservation);
    boolean delete_reservation(Reservation reservation);
    ResultSet getAllreservations();
}
