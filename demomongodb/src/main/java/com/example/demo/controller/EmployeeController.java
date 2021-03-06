package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@CachePut(value="employees", key="#firstName")
	@RequestMapping("/create")
	@ResponseBody
	public Employee create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String designation, @RequestParam String email, @RequestParam int age) {
		System.out.println("Creating record");
		Employee e = employeeService.create(firstName,lastName, designation, email, age);
		return e;
	}
	@Cacheable(value="employees", key="#firstName")
	@RequestMapping("/get")
	@ResponseBody
	public Employee getEmployee(@RequestParam String firstName) {
		System.out.println("Getting record");
		return employeeService.getByFirstName(firstName);
	}
	@Cacheable(value="employees")
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Employee> getAll(){
		System.out.println("Getting all records");
		return employeeService.getAll();
	}
	@CachePut(value="employees", key="#firstName")
	@RequestMapping("/update")
	@ResponseBody
	public Employee update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String designation, @RequestParam String email, @RequestParam int age) {
		System.out.println("updating record");
		Employee e = employeeService.update(firstName, lastName, designation, email, age);
		return e;
	}
	@CacheEvict(value="employees", key="#firstName")
	@RequestMapping("/delete")
	public String delete(@RequestParam String firstName) {
		System.out.println("Deleting record");
		employeeService.delete(firstName);
		return "Deleted "+firstName;
	}
	@CacheEvict(value="employees", key="#firstname")
	@RequestMapping("/deleteAll")
	
	public String deleteAll() {
		System.out.println("Deleting all records");
		employeeService.deleteAll();
		return "Deleted all records";
	}	
	@CacheEvict(value="employees", allEntries=true)
	@RequestMapping("/clearCache")
	public String clearCache() {
		return "Cleared Cache";
	}
}
