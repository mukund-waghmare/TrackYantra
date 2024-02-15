package com.ty.TrackYantra.dto;

import java.util.List;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Admin {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	
	private String adminFirstName;
	
	private String adminLastName;
	
	@Column(unique = true)
	private String adminEmail;
	
	private String adminPassword;
	
	private int adminAge;
	
	private long adminContact;
	
	private Designation designation;
	
	@OneToMany(mappedBy = "adminList")
	@JsonIgnore
	private List<ReportingManager> reportingManagerList;
	
	
	@OneToMany
	@JsonIgnore
	private List<Employee> trainerList;
	
	
	@OneToMany
	@JsonIgnore
	private List<Login>  logins ;
	
	@OneToMany
	@JsonIgnore
	private List<Logout>  logout ;
	
	
	
	
	
	
	
	
	

}
