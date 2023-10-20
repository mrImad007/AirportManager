<%@ page import="com.app.airportmanager.Entities.Flight" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Flight flight = (Flight) request.getAttribute("flight");
        if (flight != null) {
    %>
    <h1>Bienvenue</h1>

    <p>Ville de depart :  <%= flight.getDepartureCity() %>
    <p>Ville d'arrivée : <%= flight.getArrivalCity() %>
    <p>Heure de depart : <%= flight.getDepartureTime() %>
    <p>Heure d'arrivée : <%= flight.getArrivalTime() %>
    <p>Nombre de sieges disponnible : <%= flight.getAvailableSeats() %>
            <%
            }
        %>
</body>

</html>
