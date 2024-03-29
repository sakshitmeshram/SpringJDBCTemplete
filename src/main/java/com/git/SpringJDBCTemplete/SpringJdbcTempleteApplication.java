package com.git.SpringJDBCTemplete;

import com.git.SpringJDBCTemplete.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringJdbcTempleteApplication {
	@Autowired
    private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTempleteApplication.class, args);
	}
}
