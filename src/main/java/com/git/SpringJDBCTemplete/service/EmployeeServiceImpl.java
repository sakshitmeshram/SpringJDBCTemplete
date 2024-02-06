package com.git.SpringJDBCTemplete.service;

import com.git.SpringJDBCTemplete.model.Employee;
import com.git.SpringJDBCTemplete.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public List<Employee> getEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employee> getEmployeeByID(int ID) {
        return employeeRepo.findByID(ID);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepo.save(employee);
    }
}
