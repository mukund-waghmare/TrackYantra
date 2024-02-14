package com.ty.TrackYantra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.TrackYantra.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
}
