package com.ty.TrackYantra.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.repository.locationRepository;

@Repository
public class LocationDao {
	
	@Autowired
	locationRepository locationRepository;
	
	
	

}
