package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	//Create Operation
	public Employee create( String firstName, String lastName, String designation, String email, int age) {
		return employeeRepository.save(new Employee(firstName, lastName, designation, email, age));
	}
	//Retrieve Operation
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}
	public Employee getByFirstName(String firstName) {
		return employeeRepository.findByFirstName(firstName);
	}
	//Update Operation
	public Employee update(String firstName, String lastName, String designation, String email, int age) {
		Employee e = employeeRepository.findByFirstName(firstName);
		e.setLastName(lastName);
		e.setDesignation(designation);
		e.setEmail(email);
		e.setAge(age);
		return employeeRepository.save(e);	
	}
	//Delete Operation
	public void deleteAll() {
		employeeRepository.deleteAll();
	}
	
	public void delete(String firstName) {
		Employee e = employeeRepository.findByFirstName(firstName);
		employeeRepository.delete(e);
	}

}
