package com.ty.TrackYantra.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ty.TrackYantra.util.Designation;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	private Designation designation;
	
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
