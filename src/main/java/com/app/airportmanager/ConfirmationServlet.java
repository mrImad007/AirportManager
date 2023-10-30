package com.app.airportmanager;

import com.app.airportmanager.DAO.Implementations.FlightImpl;
import com.app.airportmanager.DAO.Implementations.ReservationImpl;
import com.app.airportmanager.Entities.Flight;
import com.app.airportmanager.Entities.Reservation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ConfirmationServlet", value = "/confirmation-serv")
public class ConfirmationServlet extends HttpServlet {
    Flight flight;
    FlightImpl flightImpl;
    Reservation reservation;
    ReservationImpl reservationIpml;

    public void init(){
        flight = new Flight();
        flightImpl = new FlightImpl();
        reservation = new Reservation();
        reservationIpml = new ReservationImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flight_id_String = request.getParameter("flightId");
        String passenger_id_String = request.getParameter("passengerId");
        String seats_number_String = request.getParameter("seatsNumber");
        String price_String = request.getParameter("price");
        int flight_id = 0;
        int passenger_id = 0;
        int seats_number = 0;
        double price = 0.0;
        double total = 0.0;

        if (flight_id_String != null){
            flight_id = Integer.parseInt(flight_id_String);
        }
        if (passenger_id_String != null){
            passenger_id = Integer.parseInt(passenger_id_String);
        }
        if (seats_number_String != null){
            seats_number = Integer.parseInt(seats_number_String);
        }
        if (price_String != null){
            price = Double.parseDouble(price_String);
        }
        total = price * seats_number;
        confirmation(flight_id,passenger_id,seats_number,price,total,request,response);
        showRecipt(flight_id,seats_number,price,total,request,response);
    }

    public void showRecipt(int flight_id, int seats_number,double price,double total,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        flight = flightImpl.getFlightById(flight_id);
        request.setAttribute("flight",flight);
        request.setAttribute("seatsNumber",seats_number);
        request.setAttribute("total",total);
        request.getRequestDispatcher("Confirmation.jsp").forward(request,response);
    }

    public void confirmation(int flight_id, int passenger_id, int seats_number, double price, double total, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        reservation.setFlightId(flight_id);
        reservation.setPassengerId(passenger_id);
        reservation.setSeatsNumber(seats_number);
        reservation.setTotal(total);
        reservationIpml.create_reservation(reservation);
    }
}
