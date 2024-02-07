package com.git.SpringJDBCTemplete.DaoImpl;

import com.git.SpringJDBCTemplete.Dao.EmployeeDao;
import com.git.SpringJDBCTemplete.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private  JdbcTemplate jdbcTemplate;



    @Override
    public void save(List<Employee> employees) {
        String sql = "insert into employee(ID , name , department , salary) values (?,?,?,?)";
        employees.stream().iterator().forEachRemaining(employee -> jdbcTemplate.update(sql , employee.getID(),employee.getName()
                ,employee.getDepartment(),employee.getSalary()));

    }

    @Override
    public List<Employee> findAll() {
        String sql = "select * from employee";

        RowMapper<Employee>rowMapper =new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee employee = new Employee();
                employee.setID(rs.getInt("ID"));
                employee.setName(rs.getString("name"));
                employee.setDepartment(rs.getString("department"));
                employee.setSalary(rs.getInt("salary"));
                return employee;
            }
        };
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public List<Employee> findByID(int ID) {

        String sql = "select * from employee where ID="+ID;

        RowMapper<Employee>rowMapper =new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee employee = new Employee();
                employee.setID(rs.getInt(1));
                employee.setName(rs.getString(2));
                employee.setDepartment(rs.getString(3));
                employee.setSalary(rs.getInt(4));
                return employee;
            }
        };
        return jdbcTemplate.query(sql,rowMapper);
    }
}
