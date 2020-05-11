package com.example.consdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.consdemo.model.Employee;
import com.example.consdemo.service.EmployeeService;



@RestController
public class ConsController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
	
	@PostMapping("insertEmp")
    public ResponseEntity<Object> insertEmployees(@RequestBody Employee employee) {
		employeeService.insertEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).build();
    }
	
	@PutMapping("updateEmp")
    public ResponseEntity<Object> updateEmployees(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).build();
    }
	
	@DeleteMapping("deleteEmp/{empNo}")
    public ResponseEntity<Object> deleteEmployees(@PathVariable("empNo") String empNo) {
		employeeService.deleteEmployee(empNo);
		return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
