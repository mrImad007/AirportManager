<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>AirAfrika - Airport Manager</title>
</head>
<body>
<h1><%= "Welcome to AirAfrika" %>
</h1>
<br/>
<a href="flight-admin">Check the available flights</a>
<br/>
<form action="flight-admin" method="POST">
    <label>
        <input type="text" name="departureCity">
        <input type="text" name="arrivalCity">
    </label>
    <input type="submit" value="Check flight">
</form>
<br/>
</body>
</html>
