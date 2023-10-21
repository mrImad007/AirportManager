package com.app.airportmanager;

import com.app.airportmanager.DAO.Implementations.FlightImpl;
import com.app.airportmanager.Entities.Flight;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FlightAdminServlet", value = "/flight-admin")
public class FlightAdminServlet extends HttpServlet {
    Flight flight;
    Flight flight1;
    FlightImpl flightImpl;

    public void init() {
        flight = new Flight();
        flight1 = new Flight();
        flightImpl = new FlightImpl();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        showAllFlights(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String route = request.getServletPath();
        String city = request.getParameter("city");
        showFlightbyCity(city, request, response);
    }

    public void showFlightbyId(int city, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        flight = flightImpl.getFlightById(city);
        request.setAttribute("flight", flight);
        request.getRequestDispatcher("/flight.jsp").forward(request, response);
    }
    public void showFlightbyCity(String city, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Flight> flights = flightImpl.getFlightsByCity(city);
        if (flights == null) {

            System.out.println("null");
        }

        for (Flight flight : flights) {
            System.out.println("Flight ID: " + flight.getFlightId());
            System.out.println("Departure City: " + flight.getDepartureCity());
            System.out.println("Arrival City: " + flight.getArrivalCity());
            System.out.println("Departure Time: " + flight.getDepartureTime());
            System.out.println("Arrival Time: " + flight.getArrivalTime());
            System.out.println("Available Seats: " + flight.getAvailableSeats());
            System.out.println();
        }
        request.setAttribute("flights", flights);
        request.getRequestDispatcher("/flight.jsp").forward(request, response);
    }

    public void showAllFlights(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Flight> flights = flightImpl.getAllFlights();
        request.setAttribute("flights", flights);
        request.getRequestDispatcher("/Flights.jsp").forward(request, response);
    }

}
