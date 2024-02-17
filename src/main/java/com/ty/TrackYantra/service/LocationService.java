package com.ty.TrackYantra.service;

import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ResponseStructure;
import org.springframework.http.ResponseEntity;

import org.springframework.http.ResponseEntity;

import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ResponseStructure;

public interface LocationService {
	
	
	
	     ResponseEntity<ResponseStructure<Location>> saveLocation(Location location,String adminEmail,String adminPassword);

	     public ResponseEntity<ResponseStructure<Location>> getLocationByLocationId(int passedLocationId,String adminEmail,String adminPassword);


         ResponseEntity<ResponseStructure<Location>> findLocationByLocationAddress(String address,String adminEmail,String adminPassword);
}
