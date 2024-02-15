package com.ty.TrackYantra.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.TrackYantra.dto.Login;
import com.ty.TrackYantra.repository.LoginRepository;

@Repository
public class LoginDao {

	@Autowired
	private LoginRepository loginRepository;
	
	public Login saveLogin(Login login) {
		return loginRepository.save(login);
	}
}
