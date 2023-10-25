<%@ page import="com.app.airportmanager.Entities.Flight" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AirAfrika - Reservation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="./Css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="script.js"></script>
</head>
<body>
    <h1>Book now</h1>
    <%
        Flight flight = (Flight) request.getAttribute("flight");
        if (flight != null) {
    %>
    <div class="container">
        <div class="card custom-bg w-75 p-4 d-flex" style="margin-left: 10%">
            <div class="row">
                <div class="pb-3 h3 text-center">Flight Details &#128747;</div>
            </div>
            <div class="row">
                <div class="pb-3 h3 text-center">From <%= flight.getDepartureCity()%> -----> To <%= flight.getArrivalCity()%></div>
            </div>
            <div class="row">
                <div class="pb-3 h5 text-center">Departure date: <%= flight.getDepartureTime()%> -- Arrival date: <%= flight.getArrivalTime()%></div>
                <div style="display: flex; justify-content: space-around">
                    <div class="pb-3 h5 text-left">Price/Seat: <%= flight.getPrice()%> MAD</div>
                    <div class="pb-3 h5 text-left">Available Seats: <%= flight.getAvailableSeats()%> seats</div>
                </div>
            </div>
            <form id="flight-form" action="flight-admin" method="post" style="display: flex; justify-content: space-around; align-items: center">
                <div class="row" >
                    <div class="form-group col-md align-items-start flex-column">
                        <label for="origin" class="d-inline-flex">Seats to book</label>
                        <input type="hidden" name="fightId" value="<%=flight.getFlightId()%>">
                        <input type="hidden" name="passengerId" value="1">
                        <input type="number" placeholder="Seats number" class="form-control" style="max-width: 200px" id="origin" name="seatsNumber" required>
                    </div>
                </div>
                <div class="row">
                    <div class="text-left col-auto">
                        <button type="submit" class="btn btn-primary">Book</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <%
        } else {
    %>
    <p>No flights available.</p>
    <%
        }
    %>
</body>
</html>
