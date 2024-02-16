package com.ty.TrackYantra.controller;

import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.service.LocationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class LocationController {
	
	
	@Autowired
	LocationService locationServiceObject;

	@GetMapping("/findLocationByLocationAddress/address/{address}")
	public ResponseEntity<ResponseStructure<Location>> findLocationByLocationAddress(@PathVariable String address){
		return locationServiceObject.findLocationByLocationAddress(address);
	}


	
	@PostMapping("/saveLocation")
	public ResponseEntity<ResponseStructure<Location>> saveLocation(@RequestBody Location location)
	{
		return locationServiceObject.saveLocation(location);
	}
	
	public ResponseEntity<ResponseStructure<Location>> getLocationByLocationId(@PathVariable int passedLocationId)
	{
		return locationServiceObject.getLocationByLocationId(passedLocationId);
	}

	

}
