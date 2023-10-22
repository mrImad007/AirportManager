package com.app.airportmanager.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "flight")
public class Flight {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "flight_id")
    private int flightId;
    @Basic
    @Column(name = "departure_city")
    private String departureCity;
    @Basic
    @Column(name = "arrival_city")
    private String arrivalCity;
    @Basic
    @Column(name = "departure_time")
    private Timestamp departureTime;
    @Basic
    @Column(name = "arrival_time")
    private Timestamp arrivalTime;
    @Basic
    @Column(name = "available_seats")
    private int availableSeats;
    @Basic
    @Column(name = "airline_id")
    private Integer airlineId;
    @Basic
    @Column(name = "stopover_id")
    private Integer stopoverId;
    @Basic
    @Column(name = "price")
    private Double price;
    @Basic
    @Column(name = "stopover")
    private Boolean stopover;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (flightId != flight.flightId) return false;
        if (availableSeats != flight.availableSeats) return false;
        if (departureCity != null ? !departureCity.equals(flight.departureCity) : flight.departureCity != null)
            return false;
        if (arrivalCity != null ? !arrivalCity.equals(flight.arrivalCity) : flight.arrivalCity != null) return false;
        if (departureTime != null ? !departureTime.equals(flight.departureTime) : flight.departureTime != null)
            return false;
        if (arrivalTime != null ? !arrivalTime.equals(flight.arrivalTime) : flight.arrivalTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = flightId;
        result = 31 * result + (departureCity != null ? departureCity.hashCode() : 0);
        result = 31 * result + (arrivalCity != null ? arrivalCity.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        result = 31 * result + availableSeats;
        return result;
    }

}
