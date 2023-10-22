<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>AirAfrika - Airport Manager</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="./Css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="script.js"></script>
</head>
<body>

<h1 style="text-align: center"><%= "Welcome to AirAfrika" %></h1>
<br/>
<div class="container">
    <div class="card custom-bg w-75 p-4 d-flex" style="margin-left: 10%">
        <div class="row">
            <div class="pb-3 h3 text-left">Flight Search &#128747;</div>
        </div>
        <form id="flight-form" action="flight-admin" method="post">
            <div class="row">
                <div class="form-group col-md align-items-start flex-column">
                    <label for="origin" class="d-inline-flex">Depart</label>
                    <input type="text" placeholder="City or Airport" class="form-control" id="origin" name="departureCity" required>
                </div>
                <div class="form-group col-md align-items-start flex-column">
                    <label for="depart" class="d-inline-flex">Arrivée</label>
                    <input type="text" placeholder="City or Airport" class="form-control" id="depart" name="arrivalCity" required>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md align-items-start flex-column">
                    <label for="departure-date" class=" d-inline-flex">Date</label>
                    <input type="date" class="form-control" id="departure-date" name="departure-date" required>
                </div>
            </div>
                <div class="form-group col-lg-6 align-items-start flex-column pt-lg-4">
                    <div class="form-check form-switch">
                        <input class="form-check-input align-self-center" type="checkbox" id="directFlights" name="stopover">
                        <label class="form-check-label d-inline-flex align-self-center" for="directFlights">Vol direct</label>
                    </div>
                </div>
            <div class="row">
                <div class="text-left col-auto">
                    <button type="submit" class="btn btn-primary">Recherche</button>
                </div>
            </div>
        </form>
    </div>
</div>
<br/>
<a href="flight-admin">Check the available flights</a>
</body>
</html>
