package com.git.SpringJDBCTemplete.Dao;

import com.git.SpringJDBCTemplete.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeDao {

    public void save(Employee employee);

    public List<Employee> findAll();

    public Employee findByID(int ID);
}
