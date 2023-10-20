package com.app.airportmanager;

import java.io.*;

import com.app.airportmanager.DAO.Implementations.AdminImpl;
import com.app.airportmanager.Entities.Users.Admin;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "No available flights so Far, please visit later !";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        AdminImpl adminImp = new AdminImpl();
        Admin admin = new Admin();
        admin = adminImp.getAdmin(1);


        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + admin.getFirstName()+ "</h1>");
        out.println("<h1>" + admin.getEmail()+ "</h1>");
        out.println("");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
