package com.example.consdemo.service;

import java.util.List;

import com.example.consdemo.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	public void insertEmployee(Employee employee);
	public void deleteEmployee(String id);
	public void updateEmployee(Employee employee);
}
