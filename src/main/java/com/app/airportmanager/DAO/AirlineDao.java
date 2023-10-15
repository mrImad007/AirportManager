package com.app.airportmanager.DAO;

import com.app.airportmanager.Entities.Airline;

import java.util.List;

public interface AirlineDao {
    boolean add_airline(Airline airline);
    List<Airline> getAllAirlines();
}
