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
import java.util.Objects;

@RestController
@RequestMapping("/")
public class EmployeeController {


    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("list")
    public ResponseEntity<Object> listOfEmployee(){
        Map<String , List<Employee>> map = new HashMap<>();
        map.put("EMP",employeeService.getEmployee());
        return new ResponseEntity<>(map,HttpStatus.OK);
    }
    @PostMapping("add")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
        if(Objects.isNull(employee))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee is empty");

        try {
            employeeService.createEmployee(employee);
            return ResponseEntity.status(HttpStatus.OK).body("Employee added to the database successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to add employee to the database");
        }
    }

    @GetMapping("list/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id){
        Map<String,Object> employeeMap = new HashMap<>();
        employeeMap.put("Employee",employeeService.getEmployeeByID(id));

        if(employeeMap.isEmpty()) throw new RuntimeException("user not found");
        return new ResponseEntity<>(employeeMap, HttpStatus.OK);
    }
}
