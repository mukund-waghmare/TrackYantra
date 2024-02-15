package com.ty.TrackYantra.dto;

import com.ty.TrackYantra.util.Status;
import org.hibernate.annotations.ManyToAny;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	
	private String employeeFirstName;
	
	private String employeeLastName;
	
	private String employeeEmail;
	
	private String employeePassword;
	
	private int employeeAge;
	
	private long employeeContact;
	
	@OneToOne
	private Location employeeLocation;
	
	private Designation designation;
	
	@ManyToOne
	private ReportingManager reportingManager;
	
	private double totalWorkHours;
	
	private Status status;

}
