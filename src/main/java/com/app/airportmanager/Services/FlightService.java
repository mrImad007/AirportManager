package com.app.airportmanager.Services;

import com.app.airportmanager.Entities.Flight;

import java.util.List;

public interface FlightService {
    boolean add_flight(Flight flight);
    boolean update_flight(Flight flight);
    boolean delete_flight(int id);
    Flight getFlightById(int id);
    List<Flight> getAllFlights();
}
