package com.app.airportmanager.Entities;

public class Escale {
    private String airport;
    private int duration;

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

    public Escale(String airport, int duration) {
        this.airport = airport;
        this.duration = duration;
    }
}
