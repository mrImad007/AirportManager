package com.app.airportmanager.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String departure_city;
    private String arrival_city;
    private Date departure_time;
    private Date arrival_time;
    private int available_seats;

    public Flight(String departure_city, String arrival_city, Date departure_time, Date arrival_time, int available_seats) {
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.available_seats = available_seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }

    public Date getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Date departure_time) {
        this.departure_time = departure_time;
    }

    public Date getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Date arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(int available_seats) {
        this.available_seats = available_seats;
    }

    public Flight() {

    }
}
