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
public class FlightServlet extends HttpServlet {
    Flight flight;
    FlightImpl flightImpl;

    public void init() {
        flight = new Flight();
        flightImpl = new FlightImpl();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String route = request.getServletPath();
        switch (route){
            case "/flight-admin" : {
                showAllFlights(request,response);
            }
            default: {
                request.getRequestDispatcher("/index.jsp");
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String route = request.getServletPath();
        switch (route){
            case "/flight-admin" : {
                String departureCity = request.getParameter("departureCity");
                String arrivalCity = request.getParameter("arrivalCity");
                showFlightbySearch(departureCity,arrivalCity, request, response);
            }
            default: {
                request.getRequestDispatcher("/index.jsp");
            }
        }
    }

    public void showFlightbyId(int city, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        flight = flightImpl.getFlightById(city);
        request.setAttribute("flight", flight);
        request.getRequestDispatcher("/flight.jsp").forward(request, response);
    }
    public void showFlightbySearch(String departureCity,String arrivalCity, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Flight> flights = flightImpl.getFlightsBySearch(departureCity,arrivalCity);
        request.setAttribute("flights", flights);
        request.getRequestDispatcher("/flight.jsp").forward(request, response);
    }

    public void showAllFlights(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Flight> flights = flightImpl.getAllFlights();
        request.setAttribute("flights", flights);
        request.getRequestDispatcher("/Flights.jsp").forward(request, response);
    }

}
