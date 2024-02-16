package com.ty.TrackYantra.service;


import com.ty.TrackYantra.dao.LocationDao;
import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ResponseStructure;

import com.ty.TrackYantra.exception.LocationByAddressNotFound;
import com.ty.TrackYantra.repository.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.TrackYantra.dao.EmployeeDao;
import com.ty.TrackYantra.dao.LocationDao;
import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.exception.LocationIdNotFoundException;

@Service
public class LocationServiceImplimentation implements LocationService {
	
	@Autowired
	LocationDao locationDaoObject;

	@Override
	public ResponseEntity<ResponseStructure<Location>> saveLocation(Location passedLocation) {
		
		Location location=locationDaoObject.saveLocation(passedLocation);
		ResponseStructure<Location> resp= new ResponseStructure<>();
		resp.setMessage("Success");
		resp.setStatusCode(HttpStatus.ACCEPTED.value());
		resp.setData(location);		
		return new ResponseEntity<ResponseStructure<Location>>(resp,HttpStatus.ACCEPTED);
	
	}

	@Override
	public ResponseEntity<ResponseStructure<Location>> getLocationByLocationId(int passedLocationId) {
		// TODO Auto-generated method stub
		Location location =locationDaoObject.getLocationByLocationId(passedLocationId);
		
		if(location!=null)
		{
			ResponseStructure<Location> resp = new ResponseStructure<>();
			resp.setMessage("Success");
			resp.setStatusCode(HttpStatus.ACCEPTED.value());
			resp.setData(location);
			
			return new ResponseEntity<ResponseStructure<Location>>(resp,HttpStatus.ACCEPTED);
		}
		
		throw new LocationIdNotFoundException("Location Doesnot Exist For Specified Id : "+passedLocationId);
	}
	

	

    @Autowired
    private LocationDao locationDao;


    @Override
    public ResponseEntity<ResponseStructure<Location>> findLocationByLocationAddress(String address) {
        Location location = locationDao.findLocationByLocationAddress(address);
        if (location!=null){
            ResponseStructure<Location> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("Success");
            responseStructure.setData(location);
            return new ResponseEntity<ResponseStructure<Location>>(responseStructure,HttpStatus.OK);
        }else
            throw new LocationByAddressNotFound("Location Of Corresponding Address Not Found");
    }
}
