package com.example.demo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	String id;
	String firstName;
	String lastName;
	String designation;
	String email;
	int    age;
	
	public Employee(String firstName, String lastName, String designation, String email, int age) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.designation=designation;
		this.email=email;
		this.age=age;
				
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "Employee First Name: "+firstName+" Last Name:"+lastName+" Designation:"+designation+" Email:"+email+" Age:"+age;
	}
}
