package com.app.airportmanager;

import com.app.airportmanager.DAO.Implementations.AdminImpl;
import com.app.airportmanager.DAO.Implementations.FlightImpl;
import com.app.airportmanager.Entities.Flight;
import com.app.airportmanager.Entities.Users.Admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/Admin-servlet")
public class AdminServlet extends HttpServlet {
    Admin admin;
    FlightImpl flightImpl;
    AdminImpl adminImpl;
    public void init(){
        admin = new Admin();
        adminImpl = new AdminImpl();
        flightImpl = new FlightImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminLogin.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        admin.setEmail(email);
        admin.setPassword(password);
        System.out.println("sevlet :"+admin.getEmail());
        auth(admin,request,response);
    }

    public void auth(Admin admin,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean check = adminImpl.login(admin);
        System.out.println(check);
        if (check == true){
            List<Flight> flights = flightImpl.getAllFlights();
            request.setAttribute("flights",flights);
            request.getRequestDispatcher("Dashboard.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
        }
    }
}

