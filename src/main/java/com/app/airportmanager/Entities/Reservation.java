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
    @Column(name = "status")
    @Setter
    @Getter
    private String status;
    @Basic
    @Column(name = "totalamount")
    @Setter
    @Getter
    private Double totalamount;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (reservationNumber != that.reservationNumber) return false;
        if (passengerId != that.passengerId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (totalamount != null ? !totalamount.equals(that.totalamount) : that.totalamount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reservationNumber;
        result = 31 * result + passengerId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (totalamount != null ? totalamount.hashCode() : 0);
        return result;
    }
}
