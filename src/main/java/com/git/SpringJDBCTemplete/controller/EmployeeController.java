package com.git.SpringJDBCTemplete.controller;

import com.git.SpringJDBCTemplete.entity.Employee;
import com.git.SpringJDBCTemplete.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("list")
    public ResponseEntity<Object> listOfEmployee(){
        Map<String , List<Employee>> map = new HashMap<>();
        map.put("EMP",employeeService.getEmployee());
        return new ResponseEntity<>(map,HttpStatus.OK);
    }
    @PostMapping("add")
    public String addEmployee(@RequestBody Employee employee){
        if(employee.equals(null))return "Employee List is empty ";
        employeeService.saveEmployee(employee);
        return "employee add in db successfully";
    }

    @GetMapping("list/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id){
        Map<String,Object> employeeMap = new HashMap<>();
        employeeMap.put("Employee",employeeService.getEmployeeByID(id));

        if(employeeMap.isEmpty()) throw new RuntimeException("user not found");
        return new ResponseEntity<>(employeeMap, HttpStatus.OK);
    }
}
