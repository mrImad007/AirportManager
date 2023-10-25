<%@ page import="com.app.airportmanager.Entities.Flight" %>
<%@ page import="java.util.List" %>
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

    <%
      List<Flight> flights = (List<Flight>) request.getAttribute("flights");
      if (flights != null && flights.size()>0) {
        for (int i = 0; i < flights.size(); i++) {
          Flight flight = flights.get(i);
    %>
    <div class="container">
      <div class="flight-details">
        <form action="reservation-serv" method="GET">
          <p>Departure City: <%= flight.getDepartureCity() %></p>
          <input type="hidden" value="<%= flight.getDepartureCity() %>" name="departureCity">
          <input type="hidden" value="<%= flight.getFlightId() %>" name="flightId">
          <p>Arrival City: <%= flight.getArrivalCity() %></p>
          <input type="hidden" value="<%= flight.getArrivalCity() %>" name="arrivalCity">
          <p>Departure Time: <%= flight.getDepartureTime() %></p>
          <input type="hidden" value="<%= flight.getDepartureTime() %>" name="departureTime">
          <input type="hidden" value="<%= flight.getStopover() %>" name="stopover">
          <p>Arrival Time: <%= flight.getArrivalTime() %></p>
          <p>Available Seats: <%= flight.getAvailableSeats() %> SEATS</p>
          <p>Price/seat: <%= flight.getPrice() %> MAD</p>
          <button type="submit" class="btn btn-primary">Choose</button>
        </form>
        <hr/>
      </div>
    </div>
  <br/>
  <br/>
  <br/>
    <%
      }
    } else {
    %>
    <p>No flights available.</p>
    <%
      }
    %>

</body>
</html>
