package com.git.SpringJDBCTemplete.service;

import com.git.SpringJDBCTemplete.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    public List<Employee> getEmployee();
    public List<Employee>getEmployeeByID(int ID);

    public void saveEmployee(Employee employee);
}
