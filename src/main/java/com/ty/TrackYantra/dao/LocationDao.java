package com.ty.TrackYantra.dao;

import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ResponseStructure;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ty.TrackYantra.repository.LocationRepository;
import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.dto.Location;


@Repository
public class LocationDao {
	
	@Autowired
    LocationRepository locationRepository;


    public Location findLocationByLocationAddress(String address) {
        return locationRepository.findByOrganisationAddress(address);
    }
	
	@Autowired
	EmployeeDao employeeDao;
	
	
	
	public Location saveLocation(Location location)
	{

		System.out.println("=================Dao======="+location);
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
