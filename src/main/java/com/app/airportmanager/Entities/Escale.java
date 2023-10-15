package com.app.airportmanager.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "escale")
public class Escale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String airport;
    private int duration;

    public Escale() {

    }
    public Escale(String airport, int duration) {
        this.airport = airport;
        this.duration = duration;
    }


    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
