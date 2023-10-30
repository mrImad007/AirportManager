package com.app.airportmanager.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Airline {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "airline_id")
    private int airlineId;
    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "airline")
    private List<Flight> flights;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airline airline = (Airline) o;

        if (airlineId != airline.airlineId) return false;
        if (name != null ? !name.equals(airline.name) : airline.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = airlineId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
