package com.ty.TrackYantra.service;

import org.springframework.http.ResponseEntity;

import com.ty.TrackYantra.dto.Designation;
import com.ty.TrackYantra.dto.Login;
import com.ty.TrackYantra.dto.ResponseStructure;

public interface LoginService {

	public ResponseEntity<ResponseStructure<Login>> saveLogin(Login login );
}
