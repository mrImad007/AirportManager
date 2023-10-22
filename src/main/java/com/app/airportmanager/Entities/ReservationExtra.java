package com.app.airportmanager.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation_extra", schema = "public", catalog = "postgres")
public class ReservationExtra {
    @Basic
    @Column(name = "reservation_id")
    @Setter
    @Getter
    private Integer reservationId;
    @Basic
    @Column(name = "extra_id")
    @Setter
    @Getter
    private Integer extraId;
    @Id
    @Setter
    @Getter
    private int id;
    @Basic
    @Column(name = "total")
    @Setter
    @Getter
    private Double total;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationExtra that = (ReservationExtra) o;

        if (reservationId != null ? !reservationId.equals(that.reservationId) : that.reservationId != null)
            return false;
        if (extraId != null ? !extraId.equals(that.extraId) : that.extraId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reservationId != null ? reservationId.hashCode() : 0;
        result = 31 * result + (extraId != null ? extraId.hashCode() : 0);
        return result;
    }


}
