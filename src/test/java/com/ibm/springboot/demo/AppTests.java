package com.ibm.springboot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.service.EmployeeService;

@SpringBootTest
class AppTests {
	@Autowired
	private EmployeeService employeeService;
	
	private static final Logger LOG = LoggerFactory.getLogger(AppTests.class);
	
	@BeforeAll
	public static void setUp() {
		LOG.info("before all");
	}
	
	@AfterAll
	public static void tearDown(){
		LOG.info("after all");
	}
	@Test
	public void testAddemp() {
	Employee emp = new Employee("asdf","Test Data ",7797979969779.9);
	assertEquals(employeeService.addEmployee(emp),emp );
	}
	@Test
	public void totalEmps() {
		assertEquals(employeeService.getAllEmployees().size(),3);
	}
	
	@Test
	public void testTest() {
		
		Integer expected= 10;
		Integer actual= 5+5;
		
		assertEquals(expected,actual);
	}
	

}
