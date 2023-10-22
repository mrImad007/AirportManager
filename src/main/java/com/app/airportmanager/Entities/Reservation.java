package com.app.airportmanager.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reservation_number")
    @Setter
    @Getter
    private int reservationNumber;
    @Basic
    @Column(name = "passenger_id")
    @Setter
    @Getter
    private int passengerId;
    @Basic
    @Column(name = "flight_id")
    @Setter
    @Getter
    private Integer flightId;
    @Basic
    @Column(name = "seats_number")
    @Setter
    @Getter
    private Integer seatsNumber;
    @Basic
    @Column(name = "total")
    @Setter
    @Getter
    private Double total;



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
