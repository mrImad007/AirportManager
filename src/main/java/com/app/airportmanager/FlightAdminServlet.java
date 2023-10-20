package com.app.airportmanager;

import com.app.airportmanager.DAO.Implementations.AdminImpl;
import com.app.airportmanager.DAO.Implementations.FlightImpl;
import com.app.airportmanager.Entities.Flight;
import com.app.airportmanager.Entities.Users.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "FlightAdminServlet", value = "/flight-admin")
public class FlightAdminServlet extends HttpServlet {
    private Admin admin;
    Flight flight;
    FlightImpl flightImpl;
    private AdminImpl adminImp;
    public void init() {
        adminImp = new AdminImpl();
        admin = new Admin();
        flight = new Flight();
        flightImpl = new FlightImpl();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        admin = adminImp.getAdmin(1);
        flight = flightImpl.getFlightById(2);
        request.setAttribute("flight",flight);
        request.getRequestDispatcher("/flight.jsp").forward(request,response);
    }
}
