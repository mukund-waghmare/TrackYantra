package com.ty.TrackYantra.dao;

import org.springframework.stereotype.Repository;

import com.ty.TrackYantra.dto.Logout;
import com.ty.TrackYantra.repository.LogoutRepository;

@Repository
public class LogoutDao
{
	private LogoutRepository logoutRepository;

	public Logout saveLogout(Logout logout) {
		return logoutRepository.save(logout);
	}

}
