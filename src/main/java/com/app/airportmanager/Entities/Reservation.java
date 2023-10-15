package com.app.airportmanager.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservation_number;
    private String status;
    private float total_amount;

    public Reservation(String status, float total_amount) {
        this.status = status;
        this.total_amount = total_amount;
    }

    public Reservation() {

    }
}
