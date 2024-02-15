package com.git.SpringJDBCTemplete.service;

import com.git.SpringJDBCTemplete.entity.Employee;

import java.util.List;


public interface EmployeeService {
    public List<Employee> getEmployee();
    public Employee getEmployeeByID(int ID);

    public void saveEmployee(Employee employee);
}
