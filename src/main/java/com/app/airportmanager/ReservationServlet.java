package com.app.airportmanager;

import com.app.airportmanager.DAO.Implementations.FlightImpl;
import com.app.airportmanager.DAO.Implementations.ReservationImpl;
import com.app.airportmanager.Entities.Flight;
import com.app.airportmanager.Entities.Reservation;
import com.app.airportmanager.Services.Implementation.FlightServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ReservationServlet", value = "/reservation-serv")
public class ReservationServlet extends HttpServlet {

    Reservation reservation;
    Flight flight;
    FlightImpl flightImpl;
    ReservationImpl reservationImpl;
    FlightServiceImpl flightService;
    public void init(){
        flight = new Flight();
        flightImpl = new FlightImpl();
        reservation = new Reservation();
        reservationImpl = new ReservationImpl();
        flightService = new FlightServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String route = request.getServletPath();
        switch (route){
            case "/reservation-serv":{
                String departureCity = request.getParameter("departureCity");
                String arrivalCity = request.getParameter("arrivalCity");
                String date = request.getParameter("departureTime");
                String escale = request.getParameter("stopover");
                boolean stopover;
                if ("true".equals(escale)) {
                    stopover = true;
                } else {
                    stopover = false;
                }
                showFlightBySearch(departureCity,arrivalCity,date,stopover,request, response);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int flight_id = Integer.parseInt(request.getParameter("flightId"));
        showReservationForm(flight_id,request,response);
    }

    public void showFlightBySearch(String departureCity,String arrivalCity,String date,boolean stopover, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Flight> flights = flightService.getFlightsBySearch(departureCity,arrivalCity,date,stopover);
        request.setAttribute("flights", flights);
        request.getRequestDispatcher("/flight.jsp").forward(request, response);
    }

    public void showReservationForm(int flight_id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        flight = flightService.getFlightById(flight_id);
        request.setAttribute("flight",flight);
        request.getRequestDispatcher("/Reservation.jsp").forward(request, response);
    }

}
