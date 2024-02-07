package com.git.SpringJDBCTemplete.Dao;

import com.git.SpringJDBCTemplete.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeDao {

    public void save(List<Employee>employeeList);

    public List<Employee> findAll();

    public List<Employee> findByID(int ID);
}
