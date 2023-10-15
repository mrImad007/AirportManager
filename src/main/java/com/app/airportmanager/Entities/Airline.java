package com.app.airportmanager.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "airline")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Airline(){}

    public Airline(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
