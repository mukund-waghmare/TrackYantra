package com.ty.TrackYantra.controller;

import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ReportingManager;
import com.ty.TrackYantra.dto.ResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.TrackYantra.dto.Location;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.service.LocationService;

@RestController
public class LocationController {
	
	
	@Autowired
	LocationService locationServiceObject;

	@Operation(description = "Find Location By Location Address",summary = "find location by location address")
	@ApiResponses(value = {@ApiResponse(description = "find location by location address",responseCode = "200"),@ApiResponse(description = "Not Found",responseCode = "404")})
	@GetMapping("/findLocationByLocationAddress/address/{address}/adminEmail/{adminEmail}/adminPassword/{adminPassword}")
	public ResponseEntity<ResponseStructure<Location>> findLocationByLocationAddress(@PathVariable String address,String adminEmail,String adminPassword){
		return locationServiceObject.findLocationByLocationAddress(address,adminEmail,adminPassword);
	}


	@Operation(description = "Save Location ",summary = "save location")
	@ApiResponses(value = {@ApiResponse(description = "save location",responseCode = "200"),@ApiResponse(description = "Not Created",responseCode = "400")})
	@PostMapping("/saveLocation/adminEmail/{adminEmail}/adminPassword/{adminPassword}")
	public ResponseEntity<ResponseStructure<Location>> saveLocation(@RequestBody Location location,String adminEmail,String adminPassword)
	{
		return locationServiceObject.saveLocation(location,adminEmail,adminPassword);
	}


	@Operation(description = "Get Location By Location Id",summary = "get location by location id")
	@ApiResponses(value = {@ApiResponse(description = "get location by location id",responseCode = "200"),@ApiResponse(description = "Not Found",responseCode = "404")})
	@GetMapping("getLocationByLocationId/adminEmail/{adminEmail}/adminPassword/{adminPassword}")
	public ResponseEntity<ResponseStructure<Location>> getLocationByLocationId(@PathVariable int passedLocationId,String adminEmail,String adminPassword)
	{
		return locationServiceObject.getLocationByLocationId(passedLocationId,adminEmail,adminPassword);
	}

	

}
