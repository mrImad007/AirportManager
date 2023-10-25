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
                break;
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
                String date = request.getParameter("departure-date");
                String escale = request.getParameter("stopover");
                boolean stopover;
                if (escale == null){
                    stopover = true;
                }else {
                    stopover = false;
                }
                showFlightBySearch(departureCity,arrivalCity,date,stopover,request, response);
                break;
            }
            default: {
                request.getRequestDispatcher("/index.jsp");
            }
        }
    }

    public void showFlightBySearch(String departureCity,String arrivalCity,String date,boolean stopover, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Flight> flights = flightImpl.getFlightsBySearch(departureCity,arrivalCity,date,stopover);
//        for (Flight flight : flights){
//            System.out.println(flight.getStopover());
//            System.out.println(flight.getDepartureCity());
//            System.out.println(flight.getArrivalCity());
//        }
        request.setAttribute("flights", flights);
        request.getRequestDispatcher("/flight.jsp").forward(request, response);
    }

    public void showAllFlights(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Flight> flights = flightImpl.getAllFlights();
//        for (Flight flight : flights){
//            System.out.println(flight.getStopover());
//            System.out.println(flight.getDepartureCity());
//            System.out.println(flight.getArrivalCity());
//        }
        request.setAttribute("flights", flights);
        request.getRequestDispatcher("/Flights.jsp").forward(request, response);
    }

}
