package com.zemoso.washmetrics.dao;

import com.zemoso.washmetrics.entities.Locations;
import com.zemoso.washmetrics.entities.SiteGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SiteGroupRepository extends JpaRepository<SiteGroups,Integer> {

//    @Query(value = "select * from site_groups where site_group_name = :siteGroupName",nativeQuery = true)
//    public SiteGroups findSiteGroupByName(String siteGroupName);
        public SiteGroups findSiteGroupById(int id);
}
