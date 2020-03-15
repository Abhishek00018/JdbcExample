package com.viva;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepo {
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public List<Employee> fetchAllEmployees(){
		String SQL = "select * from employee";
		List<Employee> employees = jdbcTemplateObject.query(SQL, new MapIntoTable());
		return employees;
	}

}
