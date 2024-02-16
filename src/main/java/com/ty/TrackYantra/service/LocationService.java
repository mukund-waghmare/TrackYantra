package com.ty.TrackYantra.service;

import org.springframework.http.ResponseEntity;

import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ResponseStructure;

public interface LocationService {
	
	
	
	     ResponseEntity<ResponseStructure<Location>> saveLocation(Location location);

	     public ResponseEntity<ResponseStructure<Location>> getLocationByLocationId(int passedLocationId);
	 	
	      

}
