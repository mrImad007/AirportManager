package com.app.airportmanager.Entities;

public class Airline {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airline(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
