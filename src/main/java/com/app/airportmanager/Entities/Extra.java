package com.app.airportmanager.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Extra {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "extra_id")
    @Setter
    @Getter
    private int extraId;
    @Basic
    @Column(name = "name")
    @Setter
    @Getter
    private String name;
    @Basic
    @Column(name = "price")
    @Setter
    @Getter
    private Double price;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Extra extra = (Extra) o;

        if (extraId != extra.extraId) return false;
        if (name != null ? !name.equals(extra.name) : extra.name != null) return false;
        if (price != null ? !price.equals(extra.price) : extra.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = extraId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
