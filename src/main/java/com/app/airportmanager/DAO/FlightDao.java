package com.app.airportmanager.DAO;

import com.app.airportmanager.Entities.Flight;

import java.util.List;

public interface FlightDao {
    boolean add_flight(Flight flight);
    boolean update_flight(Flight flight);
	boolean delete_flight(int id);
    Flight getFlightById(int id);
    List<Flight> getAllFlights();
    public List<Flight> getFlightsBySearch(String departureCity, String arrivalCity);
}
