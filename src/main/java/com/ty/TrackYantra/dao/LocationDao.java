package com.ty.TrackYantra.dao;

import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ty.TrackYantra.repository.LocationRepository;

@Repository
public class LocationDao {
	
	@Autowired
    LocationRepository locationRepository;


    public Location findLocationByLocationAddress(String address) {
        return locationRepository.findByOrganisationAddress(address);
    }
}
