package com.ty.TrackYantra.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Login {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginId;
	
	private String email;
	
	private String password;
	
	@CreationTimestamp
	private LocalTime loginTime;
	
	private LocalDate loginDate;
	
	
	
	
	

	
	
	
	
	
	
	
	

}
