package com.ty.TrackYantra.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int locationId;
	private String longitude;
	private String latitude;
	
	private String accurracy;
	
	private LocalDateTime timeStamp;
	
	private String city;
	
	private String  country;
	
	
	
	
	 
	
	
	

}
