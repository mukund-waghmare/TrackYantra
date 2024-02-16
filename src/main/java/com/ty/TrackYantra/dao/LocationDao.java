package com.ty.TrackYantra.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.repository.locationRepository;

@Repository
public class LocationDao {
	
	@Autowired
	locationRepository locationRepository;
	
	@Autowired
	EmployeeDao employeeDao;
	
	
	
	public Location saveLocation(Location location)
	{
		return locationRepository.save(location);
	}
	
	

	
	public Location getLocationByLocationId(int passedLocationId)
	{
		Optional<Location> locationOpt=locationRepository.findById(passedLocationId);
		
		if(locationOpt.isPresent())
		{
			Location location=locationOpt.get();
			return location;
		}
		return null;
		
	}
}
