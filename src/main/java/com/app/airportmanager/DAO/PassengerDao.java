package com.app.airportmanager.DAO;

import com.app.airportmanager.Entities.Users.Passenger;

public interface PassengerDao {
    boolean login(Passenger passenger);
    boolean register(Passenger passenger);
}
