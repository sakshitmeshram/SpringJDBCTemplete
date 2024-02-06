package com.git.SpringJDBCTemplete.repo;

import com.git.SpringJDBCTemplete.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepo {

    public void save(Employee employee);

    public List<Employee> findAll();

    public List<Employee> findByID(int ID);
}
