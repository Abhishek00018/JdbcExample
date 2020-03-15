package com.viva;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		EmployeeRepo employeeJdbcTemplate = (EmployeeRepo) context.getBean("employeeRepo");
		System.out.println("----------Listing Multiple Records----------");
		List<Employee> employees = employeeJdbcTemplate.fetchAllEmployees();
		for(Employee record : employees) {
			System.out.println(record);
		}
	}

}
