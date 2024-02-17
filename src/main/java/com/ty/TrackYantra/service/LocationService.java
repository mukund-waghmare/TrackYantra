package com.ty.TrackYantra.service;

import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ResponseStructure;
import org.springframework.http.ResponseEntity;

import org.springframework.http.ResponseEntity;

import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ResponseStructure;

public interface LocationService {
	
	
	
	     public ResponseEntity<ResponseStructure<Location>> saveLocation(Location location);

	     public ResponseEntity<ResponseStructure<Location>> getLocationByLocationId(int passedLocationId);
	 	
	     public ResponseEntity<ResponseStructure<Location>> findLocationByLocationAddress(String address);
	     
	     public ResponseEntity<ResponseStructure<Location>> validateLocation(int organisationId,double altitude,double lattitude);
}
