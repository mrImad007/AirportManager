package com.app.airportmanager;

import com.app.airportmanager.DAO.Implementations.PassengerImpl;
import com.app.airportmanager.Entities.Users.Passenger;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PassengerServlet", value = "/Passenger-servlet")
public class PassengerServlet extends HttpServlet {
    Passenger passenger;
    PassengerImpl passengerImpl;
    public void init(){
        passenger = new Passenger();
        passengerImpl = new PassengerImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("sevlet :"+email);
        auth(email,password,request,response);

    }

    public void auth(String email,String password,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean check = passengerImpl.login(email,password);
        System.out.println(check);
        if (check == true){
            request.getRequestDispatcher("Home.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
