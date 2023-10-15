package com.app.airportmanager.DAO;

import com.app.airportmanager.Entities.Reservation;

import java.sql.ResultSet;

public interface ReservationDao {
    public boolean create_reservation(Reservation reservation);
    public boolean update_reservation(Reservation reservation);
    public boolean delete_reservation(Reservation reservation);
    public ResultSet getAllreservations();
}
