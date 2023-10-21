package com.app.airportmanager.Services.Implementation;

import com.app.airportmanager.DAO.Implementations.FlightImpl;
import com.app.airportmanager.Entities.Flight;
import com.app.airportmanager.Services.FlightService;

import java.util.List;

public class FlightServiceImpl implements FlightService {
    FlightImpl flightImpl;

    public FlightServiceImpl(){
        flightImpl = new FlightImpl();
    }

    @Override
    public boolean add_flight(Flight flight) {
        if (flight != null){
            return flightImpl.add_flight(flight);
        }else {
            return false;
        }
    }

    @Override
    public boolean update_flight(Flight flight) {
        if (flight != null){
            return flightImpl.update_flight(flight);
        }else {
            return false;
        }
    }

    @Override
    public boolean delete_flight(int id) {
        if (id != 0){
            return flightImpl.delete_flight(id);
        }else {
            return false;
        }
    }

    @Override
    public Flight getFlightById(int id) {
        if (id != 0){
            return flightImpl.getFlightById(id);
        }else {
            return null;
        }
    }


    @Override
    public List<Flight> getAllFlights() {
        return null;
    }
}
