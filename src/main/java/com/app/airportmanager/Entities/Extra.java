package com.app.airportmanager.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "extra")
public class Extra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Extra(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public Extra() {

    }
}
