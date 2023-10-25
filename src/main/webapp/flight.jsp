<%@ page import="com.app.airportmanager.Entities.Flight" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Flight Details</title>
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
<div class="container">
    <h1>Welcome</h1>
    <%
        List<Flight> flights = (List<Flight>) request.getAttribute("flights");
        if (flights != null) {
            for (int i = 0; i < flights.size(); i++) {
                Flight flight = flights.get(i);
    %>
    <div class="flight-details">
        <form action="reservation-serv" method="POST">
            <p>Departure City: <%= flight.getDepartureCity() %></p>
            <input type="hidden" value="<%= flight.getFlightId() %>" name="flightId">
            <p>Arrival City: <%= flight.getArrivalCity() %></p>
            <p>Departure Time: <%= flight.getDepartureTime() %></p>
            <p>Arrival Time: <%= flight.getArrivalTime() %></p>
            <p>Available Seats: <%= flight.getAvailableSeats() %></p>
            <button type="submit">book now</button>
        </form>
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
