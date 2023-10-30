package com.app.airportmanager.DAO;

import com.app.airportmanager.Entities.Users.Passenger;

public interface PassengerDao {
    boolean login(String email,String password);
    boolean register(Passenger passenger);
}
