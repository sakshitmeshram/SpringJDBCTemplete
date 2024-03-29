package com.git.SpringJDBCTemplete.DaoImpl;

import com.git.SpringJDBCTemplete.Dao.EmployeeDao;
import com.git.SpringJDBCTemplete.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private  JdbcTemplate jdbcTemplate;



    @Override
    public void save(Employee employee) {

        String sql = "insert into employees(name , department , salary ) values (?,?,?)";

        try{
            jdbcTemplate.update(sql,employee.getName()
                    ,employee.getDepartment(),employee.getSalary());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> findAll() {
        String sql = "select * from employees";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
    }

    @Override
    public Employee findByID(int id) {

        String sql = "select * from employees where ID=?";
        return jdbcTemplate.queryForObject(sql , new Object[]{id},BeanPropertyRowMapper.newInstance(Employee.class));
    }
}
