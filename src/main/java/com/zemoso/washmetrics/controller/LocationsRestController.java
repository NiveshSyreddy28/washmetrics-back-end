package com.zemoso.washmetrics.controller;

import com.zemoso.washmetrics.entities.Locations;
import com.zemoso.washmetrics.exceptions.LocationNotFoundException;
import com.zemoso.washmetrics.service.WashMetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationsRestController {

    @Autowired
    WashMetricsService washMetricsService;

    @GetMapping("/locations")
    public List<Locations> getCustomers(){
        List<Locations> allLocations = washMetricsService.findAllLocations();
        return allLocations;
    }
    @GetMapping("/locations/{locationId}")
    public Locations getLocation(@PathVariable int locationId){
        Locations location = washMetricsService.findLocationById(locationId);

        if(location==null){
            throw new LocationNotFoundException("Location id not found - "+locationId);
        }
        return location;
    }

    @PostMapping("/locations")
    public Locations addLocation(@RequestBody Locations location){

        washMetricsService.saveLocation(location);
//        location.setId(0);
        return location;
    }

    @PutMapping("/locations")
    public Locations updateLocation(@RequestBody Locations location){
        washMetricsService.saveLocation(location);
        return location;
    }

    // adding mapping DELETE /customers/{customerId}
    @DeleteMapping("/locations/{locationId}")
    public String deleteLocation(@PathVariable int locationId){

        Locations location = washMetricsService.findLocationById(locationId);
        if(location == null){
            throw  new LocationNotFoundException("Location id not found - "+locationId);
        }

        washMetricsService.deleteLocationById(locationId);
        return  "Deleted Location id - "+locationId;
    }

}
