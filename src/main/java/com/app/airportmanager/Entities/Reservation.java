package com.app.airportmanager.Entities;

import com.app.airportmanager.Entities.Users.Passenger;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reservation_number")
    private int reservationNumber;
    @Basic
    @Column(name = "passenger_id")
    private int passengerId;
    @Basic
    @Column(name = "flight_id")
    private Integer flightId;
    @Basic
    @Column(name = "seats_number")
    private Integer seatsNumber;
    @Basic
    @Column(name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "passenger_id", referencedColumnName = "passenger_id", insertable = false, updatable = false)
    private Passenger passenger;
    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id", insertable = false, updatable = false)
    private Flight flight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (reservationNumber != that.reservationNumber) return false;
        if (passengerId != that.passengerId) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = reservationNumber;
        result = 31 * result + passengerId;
        return result;
    }

}
