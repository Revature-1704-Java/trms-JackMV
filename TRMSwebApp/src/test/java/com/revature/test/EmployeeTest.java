package com.revature.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.revature.beans.Employee;

public class EmployeeTest {
	Employee e = null;
	
	@Before
	public void init() {
		e = new Employee(1, "Jack", "McCabe", 3);
	}
	
	@Test
	public void getFirstNameReturnsRightName() {
		assertEquals("Jack", e.getFirstName());
	}
	
	@Test
	public void setFirstNameChangesName() {
		e.setFirstName("NotJack");
		assertEquals("NotJack", e.getFirstName());
	}
	
	@Test
	public void getLastNameReturnsRightName() {
		assertEquals("McCabe", e.getLastName());
	}
	
	@Test
	public void setLastNameChangesName() {
		e.setLastName("NotMcCabe");
		assertEquals("NotMcCabe", e.getLastName());
	}
}
