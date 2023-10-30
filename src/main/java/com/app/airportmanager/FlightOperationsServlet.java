package com.app.airportmanager;

import com.app.airportmanager.DAO.Implementations.FlightImpl;
import com.app.airportmanager.Entities.Flight;
import com.app.airportmanager.Services.FlightService;
import com.app.airportmanager.Services.Implementation.FlightServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FlightOperationsServlet", value = "/FlightOperationsServlet")
public class FlightOperationsServlet extends HttpServlet {
    FlightServiceImpl flightService;
    FlightImpl flightImpl;
    public void init(){
        flightService = new FlightServiceImpl();
        flightImpl = new FlightImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_String = request.getParameter("flightId");
        System.out.println("srtring : "+id_String);
        int id = 0;
        if (id_String != null){
            id = Integer.parseInt(id_String);
        }
        System.out.println(id);
        deleteFlight(id,request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void deleteFlight(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean checker = flightService.delete_flight(id);
        String message;
        if (checker) {
            message = "Flight successfully deleted.";
        } else {
            message = "There was a problem deleting the flight.";
        }
        List<Flight> flights = flightImpl.getAllFlights();
        request.setAttribute("flights",flights);
        request.getRequestDispatcher("Dashboard.jsp").forward(request,response);
    }



    public void updateFlight(int id,HttpServletRequest request, HttpServletResponse response){

    }

}
