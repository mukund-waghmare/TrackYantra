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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
	
	private Designation designation;
	
	@CreationTimestamp
	private LocalTime loginTime;
	
	private LocalDate loginDate;
	
	@OneToOne
	private Location location;
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private ReportingManager manager;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
  
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;

	


}
