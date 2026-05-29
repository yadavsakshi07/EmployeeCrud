package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	public Employee saveEmployee(Employee employee) {
		Employee dbEmployee = repository.save(employee);
		return dbEmployee;
		
	}
	public List<Employee> getAllEmployees(){
		List<Employee> allEmployees = repository.findAll();
		return allEmployees;
	}
	
	public void deleteEmployeeById(int id) {
		getEmpById(id);
		repository.deleteById(id);
	}
	
	public Employee  getEmpById(int id) {
//		Employee e = repository.findById(id).get();
//		return e;
		Employee e = repository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Please provide valid employee id"));
		return e;		
	}
	
	public Employee updateEmployee(Employee employee) {
		getEmpById(employee.getId()); //checking if id is valid or not
		Employee updatedEmployee = repository.save(employee);
		return updatedEmployee;
	}
	

}
