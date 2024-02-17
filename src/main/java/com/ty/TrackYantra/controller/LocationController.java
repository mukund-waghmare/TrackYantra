package com.ty.TrackYantra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.service.LocationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class LocationController {
	
	
	@Autowired
	LocationService locationServiceObject;
	
	@PostMapping("/saveLocation")
	@Operation(description = "saving location",summary = "saving location")
	@ApiResponses(value = {@ApiResponse(description = "location saved Successfully", responseCode = "201"),@ApiResponse(description = "Enable to save location", responseCode = "400")})
	public ResponseEntity<ResponseStructure<Location>> saveLocation(@RequestBody Location location)
	{
		return locationServiceObject.saveLocation(location);
	}
	
	@Operation(description = "getting location By Id",summary = "getting location By Id")
	@ApiResponses(value= {@ApiResponse(description = " Employee found By Id",responseCode = "201"),@ApiResponse(description = "Employee Doesnot Exist For Specified Id",responseCode = "404")})
	public ResponseEntity<ResponseStructure<Location>> getLocationByLocationId(@PathVariable int passedLocationId)
	{
		return locationServiceObject.getLocationByLocationId(passedLocationId);
	}

}
