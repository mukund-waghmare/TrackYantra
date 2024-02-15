package com.ty.TrackYantra.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.TrackYantra.dto.Employee;
import com.ty.TrackYantra.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployeeById(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
		return employee;
	}
	
	public Employee getEmployee(int employeeId) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		if(optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		}else {
			return null;
		}
	}
	
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	 
	}
	
	
	
	

}
