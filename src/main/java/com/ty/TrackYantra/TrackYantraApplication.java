package com.ty.TrackYantra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ty.TrackYantra.dao.AdminDao;
import com.ty.TrackYantra.dto.Admin;
import com.ty.TrackYantra.dto.Designation;
import com.ty.TrackYantra.dto.Location;

import jakarta.annotation.PostConstruct;

@SpringBootApplication

public class TrackYantraApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackYantraApplication.class, args);
	}
	
}
