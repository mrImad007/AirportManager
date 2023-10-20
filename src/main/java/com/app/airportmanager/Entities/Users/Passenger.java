package com.app.airportmanager.Entities.Users;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "passenger_id")
    @Setter
    @Getter
    private int passengerId;
    @Basic
    @Column(name = "first_name")
    @Setter
    @Getter
    private String firstName;
    @Basic
    @Column(name = "last_name")
    @Setter
    @Getter
    private String lastName;
    @Basic
    @Column(name = "email")
    @Setter
    @Getter
    private String email;
    @Basic
    @Column(name = "password")
    @Setter
    @Getter
    private String password;
    @Basic
    @Column(name = "phone_number")
    @Setter
    @Getter
    private String phoneNumber;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger passenger = (Passenger) o;

        if (passengerId != passenger.passengerId) return false;
        if (firstName != null ? !firstName.equals(passenger.firstName) : passenger.firstName != null) return false;
        if (lastName != null ? !lastName.equals(passenger.lastName) : passenger.lastName != null) return false;
        if (email != null ? !email.equals(passenger.email) : passenger.email != null) return false;
        if (password != null ? !password.equals(passenger.password) : passenger.password != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(passenger.phoneNumber) : passenger.phoneNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = passengerId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }
}
