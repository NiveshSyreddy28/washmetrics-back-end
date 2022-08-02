package com.zemoso.washmetrics.entities;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "site_groups")
@NoArgsConstructor
@Getter
@Setter
public class SiteGroups {

    @Column(name = "site_group_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "site_group_name")
    private String siteGroupName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.DETACH,
            CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name = "site_locations",
            joinColumns = @JoinColumn(name = "site_group_id"),inverseJoinColumns = @JoinColumn(name = "location_id")
    )

    private List<Locations> LocationsList;

    public SiteGroups(String siteGroupName) {
        this.siteGroupName = siteGroupName;
    }

    public void addLocations(Locations location){
        if (LocationsList==null){
            LocationsList = new ArrayList<>();
        }
        LocationsList.add(location);
    }
}
