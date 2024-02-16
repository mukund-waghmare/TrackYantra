package com.ty.TrackYantra.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.ty.TrackYantra.util.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReportingManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportingManagerId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private int age;
	
	private long contact;
	
	private Designation designation;
	
	@OneToOne
	private Location location;
	
	private byte [] image;

	private Status status;
	
	@OneToMany(mappedBy ="reportingManager" )
	@JsonIgnore
	private List<Employee> employeeList;	
	

	@ManyToOne
	@JoinColumn(name = "reportingManagerList")
	private Admin admin;
	

}
