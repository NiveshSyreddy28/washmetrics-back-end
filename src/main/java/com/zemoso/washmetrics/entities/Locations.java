
package com.zemoso.washmetrics.entities;

import lombok.*;
import javax.persistence.*;

@Entity
//@Table(name = "locations",uniqueConstraints={@UniqueConstraint(columnNames={"location_name"})})
//@NoArgsConstructor
@Getter
@Setter

public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int id;

    @Column(name = "location_name")
    private String locationName;

    public Locations() {
    }
}
