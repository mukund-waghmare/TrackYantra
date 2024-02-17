package com.ty.TrackYantra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.TrackYantra.dto.Logout;
import com.ty.TrackYantra.dto.ResponseStructure;
import com.ty.TrackYantra.service.LogoutService;

@RestController
public class LogoutController 
{
	@Autowired
	private LogoutService logoutService;
	
	@PostMapping("/logout")
	public ResponseEntity<ResponseStructure<Logout>> saveLogout(@RequestBody Logout logout)
	{
		return logoutService.saveLogout(logout);
	}
	

}
