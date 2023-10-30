<%@ page import="com.app.airportmanager.Entities.Flight" %><%--
  Created by IntelliJ IDEA.
  User: imads
  Date: 26/10/2023
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Booking - confirmation</title>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  <script src="scode.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<%
  Flight flight = (Flight) request.getAttribute("flight");
  int seatsNumber = (int) request.getAttribute("seatsNumber");
  double total = (double) request.getAttribute("total");
  if (flight != null) {
%>
<div class='container'>
  <div class='row' style='padding-top:25px; padding-bottom:25px;'>
    <div class='col-md-12'>
      <div id='mainContentWrapper'>
        <div class="col-md-8 col-md-offset-2">
          <h2 style="text-align: center;">
            Review Your Order
          </h2>
          <hr/>
          <div class="shopping_cart">
            <form class="form-horizontal" role="form" action="" method="post" id="payment-form">
              <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                  <div class="panel-heading">
                    <h4 class="panel-title">
                      <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Review
                        Your Order</a>
                    </h4>
                  </div>
                  <div id="collapseOne" class="panel-collapse collapse in">
                    <div class="panel-body">
                      <div class="items">
                        <div class="col-md-9">
                          <table class="table table-striped">
                            <tr>
                            </tr>
                            <tr>
                              <td>
                                <ul>
                                  <li>Booked seats :</li>
                                  <li>Price per seat : </li>
                                </ul>
                              </td>
                              <td>
                                <b><%= seatsNumber%></b><br/>
                                <b><%= flight.getPrice()%> MAD</b>
                              </td>
                            </tr>
                          </table>
                        </div>
                        <div class="col-md-3">
                          <div style="text-align: center;">
                            <h3>Order Total</h3>
                            <h3><span style="color:green;"><%= total%> MAD</span></h3>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>

                </div>
              </div>
        </form>
      </div>
    </div>
  </div>
</div>
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

