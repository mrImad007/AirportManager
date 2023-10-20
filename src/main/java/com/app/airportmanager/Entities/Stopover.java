package com.app.airportmanager.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Stopover {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stopover_id")
    @Setter
    @Getter
    private int stopoverId;
    @Basic
    @Column(name = "airport")
    @Setter
    @Getter
    private String airport;
    @Basic
    @Column(name = "duration")
    @Setter
    @Getter
    private Integer duration;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stopover stopover = (Stopover) o;

        if (stopoverId != stopover.stopoverId) return false;
        if (airport != null ? !airport.equals(stopover.airport) : stopover.airport != null) return false;
        if (duration != null ? !duration.equals(stopover.duration) : stopover.duration != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stopoverId;
        result = 31 * result + (airport != null ? airport.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        return result;
    }
}
