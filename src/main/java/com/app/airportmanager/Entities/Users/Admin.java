package com.app.airportmanager.Entities.Users;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String code;
    private String email;
    private String phone_number;
    private String password;

    public Admin() {
    }

    public Admin(String first_name, String last_name, String code, String email, String phone_number, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.code = code;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
