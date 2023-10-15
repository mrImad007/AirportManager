package com.app.airportmanager.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "reservation_extra")
public class ReservationExtra {
    private int reservation_id;
    private int extra_id;
    private float total_amount;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public ReservationExtra() {

    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getExtra_id() {
        return extra_id;
    }

    public void setExtra_id(int extra_id) {
        this.extra_id = extra_id;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public ReservationExtra(int reservation_id, int extra_id, float total_amount) {
        this.reservation_id = reservation_id;
        this.extra_id = extra_id;
        this.total_amount = total_amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
