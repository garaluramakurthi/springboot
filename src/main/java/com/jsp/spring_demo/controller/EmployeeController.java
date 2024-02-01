package com.jsp.spring_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.spring_demo.dao.EmployeeDao;
import com.jsp.spring_demo.dto.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDao dao;
	@PostMapping("/save")
	public void saveEmployee(@RequestBody Employee employee) {
		dao.saveEmployee(employee);
	}
	
//-------we can fetch the details(@RequestParam ) by passing params in the url in the form of key value pair
	
	@GetMapping("/byid")
	public Employee fetchById(@RequestParam int id) {
		return dao.fetchEmployeeByID(id);
	}
//---------------another way---------------------------
//---------fetching details via url /id  @path variable---------------
//	@GetMapping("/byid/{id}")
//	public Employee fetchById(@PathVariable int id) {
//		return dao.fetchEmployeeByID(id);
//	}
	
	@DeleteMapping("/delete")
	public Employee deleteEmployeeById(@PathVariable int id) {
		return dao.deleteEmployeeById(id);
	}
	
	@PutMapping("/update")
	public Employee updateEmployeeById(@RequestBody Employee employee) {
		System.out.println(employee);
		return dao.updateEmployee(employee);
	}
}
