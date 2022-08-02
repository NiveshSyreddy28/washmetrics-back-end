package com.zemoso.washmetrics.service;

import com.zemoso.washmetrics.entities.Locations;
import com.zemoso.washmetrics.entities.SiteGroups;

import java.util.List;

public interface WashMetricsService {

    List<Locations> findAllLocations();

    public Locations findLocationById(int id);

    public void saveLocation(Locations location);

    public void deleteLocationById(int id);

    List<SiteGroups> findAllSiteGroups();

    public SiteGroups findSiteGroupById(int id);

    public void saveSiteGroup(SiteGroups siteGroup);

    public void deleteSiteGroupById(int id);
}
