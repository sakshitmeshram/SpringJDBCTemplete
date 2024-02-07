package com.git.SpringJDBCTemplete;

import com.git.SpringJDBCTemplete.entity.Employee;
import com.git.SpringJDBCTemplete.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbcTempleteApplication implements CommandLineRunner {
	@Autowired
    private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTempleteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			Employee employee = new Employee();
			employee.setID(2);
			employee.setName("ravi");
			employee.setDepartment("IT");
			employee.setSalary(80000);

	}
}
