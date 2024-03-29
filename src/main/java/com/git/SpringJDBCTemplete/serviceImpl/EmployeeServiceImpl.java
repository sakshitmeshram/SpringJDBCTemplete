package com.git.SpringJDBCTemplete.serviceImpl;

import com.git.SpringJDBCTemplete.entity.Employee;
import com.git.SpringJDBCTemplete.Dao.EmployeeDao;
import com.git.SpringJDBCTemplete.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeRepo;
    @Override
    public List<Employee> getEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeByID(int id) {
        return employeeRepo.findByID(id);
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepo.save(employee);
    }
}
