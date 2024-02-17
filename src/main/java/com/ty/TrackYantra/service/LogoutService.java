package com.ty.TrackYantra.service;

import org.springframework.http.ResponseEntity;

import com.ty.TrackYantra.dto.Logout;
import com.ty.TrackYantra.dto.ResponseStructure;

public interface LogoutService
{
	public ResponseEntity<ResponseStructure<Logout>> saveLogout(Logout logout);

}
