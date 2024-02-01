package com.jsp.spring_demo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.jsp.spring_demo.dto.Employee;
import com.jsp.spring_demo.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	
	@Autowired
	private EmployeeRepo repo;
	
	public void saveEmployee( Employee employee) {
		repo.save(employee);
	}
	//-----------give exception if data is not present----------------
//	public Employee fetchEmployeeByID(int id) {
//		Employee emp =repo.findById(id).get();
//		return emp;
//	}
	//--------------to overcome exception is the data is not present----------------
	public Employee fetchEmployeeByID(int id) {
		Optional<Employee> emp =repo.findById(id);
		if(emp.isPresent())
			return emp.get();
		else
			return null;
	}
	
	public Employee deleteEmployeeById(int id) {
		Optional <Employee> emp= repo.findById(id);
		if(emp.isPresent()) {
			repo.deleteById(id);
			return emp.get();
		}
		else
			return null;
	}
	
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> emp=repo.findById(employee.getId());
		if(emp.isPresent()) {
			return repo.save(employee);
		}
		else {
			return null;
		}
	}
}
