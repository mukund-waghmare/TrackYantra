package com.ty.TrackYantra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ty.TrackYantra.service.LocationService;

@RestController
public class LocationController {
	
	
	@Autowired
	LocationService locationServiceObject;
	
	
	

}
