package com.zemoso.washmetrics.controller;

import com.zemoso.washmetrics.entities.SiteGroups;
import com.zemoso.washmetrics.exceptions.LocationNotFoundException;
import com.zemoso.washmetrics.service.WashMetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SiteGroupRestController {

    @Autowired
    WashMetricsService washMetricsService;

    @GetMapping("/site-groups")
    public List<SiteGroups> getSiteGroups(){
        List<SiteGroups> allSiteGroups = washMetricsService.findAllSiteGroups();
        return allSiteGroups;
    }
    @GetMapping("/site-groups/{siteGroupId}")
    public SiteGroups getSiteGroup(@PathVariable int siteGroupId){
        SiteGroups siteGroup = washMetricsService.findSiteGroupById(siteGroupId);

        if(siteGroup==null){
            throw new LocationNotFoundException("Site Group id not found - "+siteGroupId);
        }
        return siteGroup;
    }

    @PostMapping("/site-groups")
    public SiteGroups addSiteGroup(@RequestBody SiteGroups siteGroup){

        washMetricsService.saveSiteGroup(siteGroup);
//        location.setId(0);
        return siteGroup;
    }

    @PutMapping("/site-groups")
    public SiteGroups updateSiteGroup(@RequestBody SiteGroups siteGroup){
        washMetricsService.saveSiteGroup(siteGroup);
        return siteGroup;
    }

    // adding mapping DELETE /customers/{customerId}
    @DeleteMapping("/site-groups/{siteGroupId}")
    public String deleteSiteGroup(@PathVariable int siteGroupId){

        SiteGroups siteGroup = washMetricsService.findSiteGroupById(siteGroupId);
        if(siteGroup == null){
            throw  new LocationNotFoundException("Site Group id not found - "+siteGroupId);
        }

        washMetricsService.deleteSiteGroupById(siteGroupId);
        return  "Deleted Site Group id - "+siteGroupId;
    }

}

