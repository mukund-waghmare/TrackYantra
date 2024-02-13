package com.ty.TrackYantra.dto;

import java.time.LocalDate;
import java.time.LocalTime;
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Logout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int logoutId;
	
	private String logoutEmail;
	
	private String logoutPassword;
	
	@CreationTimestamp
	private LocalTime logoutTime;
	
	private LocalDate logoutDate;
	
	

}
