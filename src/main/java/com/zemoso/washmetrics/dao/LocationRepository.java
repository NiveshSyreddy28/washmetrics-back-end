package com.zemoso.washmetrics.dao;

import com.zemoso.washmetrics.entities.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Locations,Integer> {

    public Locations findById(int id);
}
