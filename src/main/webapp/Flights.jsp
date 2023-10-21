<%@ page import="com.app.airportmanager.Entities.Flight" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: imads
  Date: 21/10/2023
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Available flights</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      text-align: center;
      background-color: #f4f4f4;
    }
    .container {
      max-width: 600px;
      margin: 0 auto;
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    }
    h1 {
      color: #007bff;
    }
    p {
      margin: 10px 0;
    }
  </style>
</head>
<body>
  <H1>Available flights</H1><br/>
  <div class="container">
    <h1>Welcome</h1>
    <%
      List<Flight> flights = (List<Flight>) request.getAttribute("flights");
      if (flights != null) {
        for (int i = 0; i < flights.size(); i++) {
          Flight flight = flights.get(i);
    %>
    <div class="flight-details">
      <p>Departure City: <%= flight.getDepartureCity() %></p>
      <p>Arrival City: <%= flight.getArrivalCity() %></p>
      <p>Departure Time: <%= flight.getDepartureTime() %></p>
      <p>Arrival Time: <%= flight.getArrivalTime() %></p>
      <p>Available Seats: <%= flight.getAvailableSeats() %></p>
      <hr/>
    </div>
    <%
      }
    } else {
    %>
    <p>No flights available.</p>
    <%
      }
    %>
  </div>
</body>
</html>
