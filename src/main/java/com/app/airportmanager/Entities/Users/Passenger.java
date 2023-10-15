package com.app.airportmanager.Entities.Users;

import jakarta.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String code;
    private String email;
    private String phone_number;
    private String password;

    public Passenger() {

    }
    public Passenger(String first_name, String last_name, String code, String email, String phone_number, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.code = code;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
