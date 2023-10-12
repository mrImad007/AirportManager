package com.app.airportmanager.Entities.Users;

public abstract class User {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;

    public User( String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
