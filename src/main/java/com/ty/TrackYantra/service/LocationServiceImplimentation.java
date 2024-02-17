package com.ty.TrackYantra.service;


import com.ty.TrackYantra.dao.AdminDao;
import com.ty.TrackYantra.dao.LocationDao;
import com.ty.TrackYantra.dto.*;

import com.ty.TrackYantra.exception.AdminNotFoundException;
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

	@Autowired
	private AdminDao adminDao;

	@Override
	public ResponseEntity<ResponseStructure<Location>> saveLocation(Location passedLocation,String adminEmail,String adminPassword) {
		Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
		if (admin!=null) {
			Location location = locationDaoObject.saveLocation(passedLocation);
			if (location!=null) {
				ResponseStructure<Location> resp = new ResponseStructure<>();
				resp.setMessage("Success");
				resp.setStatusCode(HttpStatus.ACCEPTED.value());
				resp.setData(location);
				return new ResponseEntity<ResponseStructure<Location>>(resp, HttpStatus.ACCEPTED);
			}else
				throw new LocationIdNotFoundException("Location Id Not Found");
		}else
			throw new AdminNotFoundException("Admin Not Found");
	
	}

	@Override
	public ResponseEntity<ResponseStructure<Location>> getLocationByLocationId(int passedLocationId,String adminEmail,String adminPassword) {
		Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
		if (admin!=null) {
			Location location = locationDaoObject.getLocationByLocationId(passedLocationId);
			if (location != null) {
				ResponseStructure<Location> resp = new ResponseStructure<>();
				resp.setMessage("Success");
				resp.setStatusCode(HttpStatus.ACCEPTED.value());
				resp.setData(location);

				return new ResponseEntity<ResponseStructure<Location>>(resp, HttpStatus.ACCEPTED);
			}

			throw new LocationIdNotFoundException("Location Doesnot Exist For Specified Id : " + passedLocationId);
		}else
			throw new AdminNotFoundException("Admin Not Found");
	}


    @Override
    public ResponseEntity<ResponseStructure<Location>> findLocationByLocationAddress(String address,String adminEmail,String adminPassword) {
        Admin admin = adminDao.getAdminByEmailAndPassword(adminEmail,adminPassword);
		if (admin!=null) {
			Location location = locationDaoObject.findLocationByLocationAddress(address);
			if (location != null) {
				ResponseStructure<Location> responseStructure = new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Success");
				responseStructure.setData(location);
				return new ResponseEntity<ResponseStructure<Location>>(responseStructure, HttpStatus.OK);
			} else
				throw new LocationByAddressNotFound("Location Of Corresponding Address Not Found");
		}else
			throw new AdminNotFoundException("Admin Not Found");
    }

	@Override
	public ResponseEntity<ResponseStructure<Location>> validateLocation(int organisationId, double altitude,double lattitude) {
		// TODO Auto-generated method stub
		return null;
		
	}

	
}
