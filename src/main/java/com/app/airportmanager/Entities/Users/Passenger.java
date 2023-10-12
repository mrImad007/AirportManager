package com.app.airportmanager.Entities.Users;

public class Passenger extends User{
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Passenger(String code, String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
        this.code = code;
    }
}
