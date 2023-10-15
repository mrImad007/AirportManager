package com.app.airportmanager.DAO;

import com.app.airportmanager.Entities.Flight;

import java.util.List;

public interface FlightDao {
    public boolean add_flight(Flight flight);
    public boolean update_flight(Flight flight);
	public boolean delete_flight(Flight flight);
    Flight getFlightById(Flight flight);
    List<Flight> getAllFlights();
}
