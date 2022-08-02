package com.zemoso.washmetrics.service;

import com.zemoso.washmetrics.dao.LocationRepository;
import com.zemoso.washmetrics.dao.SiteGroupRepository;
import com.zemoso.washmetrics.entities.Locations;
import com.zemoso.washmetrics.entities.SiteGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WashMetricsServiceImpl implements WashMetricsService {

    private SiteGroupRepository siteGroupRepository;
    private LocationRepository locationRepository;

    @Autowired
    public WashMetricsServiceImpl(SiteGroupRepository siteGroupRepository, LocationRepository locationRepository) {
        this.siteGroupRepository = siteGroupRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Locations> findAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Locations findLocationById(int id) {
        return locationRepository.findById(id);
    }

    @Override
    public void saveLocation(Locations location) {
         locationRepository.save(location);
    }

    @Override
    public void deleteLocationById(int id) {
        locationRepository.deleteById(id);
    }

    @Override
    public List<SiteGroups> findAllSiteGroups() {
        return siteGroupRepository.findAll();
    }

    @Override
    public SiteGroups findSiteGroupById(int id) {
        return siteGroupRepository.findSiteGroupById(id);
    }

    @Override
    public void saveSiteGroup(SiteGroups siteGroup) {
        siteGroupRepository.save(siteGroup);
    }

    @Override
    public void deleteSiteGroupById(int id) {
        siteGroupRepository.deleteById(id);
    }
}
