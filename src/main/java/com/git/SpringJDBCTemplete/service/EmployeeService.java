package com.git.SpringJDBCTemplete.service;

import com.git.SpringJDBCTemplete.entity.Employee;

import java.util.List;


public interface EmployeeService {
    public List<Employee> getEmployee();
    public List<Employee>getEmployeeByID(int ID);

    public void saveEmployee(List<Employee>employeeList);
}
