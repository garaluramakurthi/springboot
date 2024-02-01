package com.jsp.spring_demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.spring_demo.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
