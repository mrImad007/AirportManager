package com.app.airportmanager.DAO;

import com.app.airportmanager.Entities.Users.Passenger;

public interface PassengerDao {
    public boolean login(Passenger passenger);
    public boolean register(Passenger passenger);

}
