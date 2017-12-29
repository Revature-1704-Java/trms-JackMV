package com.revature.beans;

public class Employee {

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", empType=" + empType + "]";
	}

	private String firstName;
	private String lastName;
	private int empType;
	
	public Employee (String firstName, String lastName, int employeeType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.empType = employeeType;
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

	public int getEmpType() {
		return empType;
	}

	public void setEmpType(int empType) {
		this.empType = empType;
	}

}
