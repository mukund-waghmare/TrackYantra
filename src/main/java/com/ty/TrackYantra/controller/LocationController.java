package com.ty.TrackYantra.controller;

import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ty.TrackYantra.service.LocationService;

@RestController
public class LocationController {
	
	
	@Autowired
	LocationService locationServiceObject;
	
	@GetMapping("/findLocationByLocationAddress/address/{address}")
	public ResponseEntity<ResponseStructure<Location>> findLocationByLocationAddress(@PathVariable String address){
		return locationServiceObject.findLocationByLocationAddress(address);
	}


	

}
