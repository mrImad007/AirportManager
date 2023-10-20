package com.app.airportmanager.Entities.Users;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin")
public class Admin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "admin_id")
    @Setter
    @Getter
    private int adminId;
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

        Admin admin = (Admin) o;

        if (adminId != admin.adminId) return false;
        if (firstName != null ? !firstName.equals(admin.firstName) : admin.firstName != null) return false;
        if (lastName != null ? !lastName.equals(admin.lastName) : admin.lastName != null) return false;
        if (email != null ? !email.equals(admin.email) : admin.email != null) return false;
        if (password != null ? !password.equals(admin.password) : admin.password != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(admin.phoneNumber) : admin.phoneNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adminId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }
}
