package com.example.consdemo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.consdemo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		RestTemplate restTemplate = new RestTemplate();
		List<Employee> employeeList = new ArrayList<Employee>();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<Employee[]> response = restTemplate.exchange("http://localhost:8080/employees", HttpMethod.GET, requestEntity,Employee[].class);
		Employee[] employees = response.getBody();
		employeeList = Arrays.asList(employees);
		return employeeList;
	}

	@Override
	public void insertEmployee(Employee employee) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForEntity("http://localhost:8080/insertEmp", 
				employee, Employee[].class);
		
	}

	@Override
	public void deleteEmployee(String id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8080/" + id);
	
	}

	@Override
	public void updateEmployee(Employee employee) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://localhost:8080/updateEmp", 
				employee, Employee[].class);
		
	}

}
