package com.example.demo.controllers;



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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Employee;
import com.example.demo.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
//	@PostMapping("")
//	public Employee saveEmployee(@RequestBody Employee employee) {
//		Employee dbEmployee=service.saveEmployee(employee);
//		return dbEmployee;
//	}
	
	@PostMapping("")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		System.out.println("Recevied employee object:" +employee);
		Employee dbEmployee=service.saveEmployee(employee);
		return new ResponseEntity<>(dbEmployee,HttpStatus.CREATED);
	}
//	@GetMapping("")
//	public List<Employee> getAllEmployees(){
//		return service.getAllEmployees();
//		}
	
	
	@GetMapping("")
	public ResponseEntity<?>getAllEmployees(){
		List<Employee> employee = service.getAllEmployees();
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	
	//DELETE http://localhost:8080/employees/1
//	@DeleteMapping("/{id}")
//	public String deleteEmployeeById(@PathVariable int id) {
//		System.out.println("Received employee id:"+id);
//		service.deleteEmployeeById(id);
//		return"Employee deleted";
//		
//	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable int id) {
		System.out.println("Received employee id:"+id);
		service.deleteEmployeeById(id);
		return new ResponseEntity<>("Employee deleted",HttpStatus.NO_CONTENT);
		}
	
	//GET http://localhost:8080/employees/1
//	@GetMapping("/{id}")
//	public Employee getEmployeeById(@PathVariable int id) {
//		Employee e= service.getEmpById(id);
//		return e;
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeByIc(@PathVariable int id) {
		Employee e= service.getEmpById(id);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	
	//PUT http://localhost:8080/employees?id=2
	//request parameter id =2
//	@PutMapping("")
//	public Employee updateById(@RequestParam ("id") int id,
//			@RequestBody Employee employee) {
//		System.out.println("Recevied employee object:" +employee);
//		employee.setId(id);
//		Employee updatedEmployee = service.updateEmployee(employee);
//				return updatedEmployee;
//	}
	
	
	
	@PutMapping("")
	public ResponseEntity<?> updateById(@RequestParam ("id") int id,
			@RequestBody Employee employee) {
		System.out.println("Recevied employee object:" +employee);
		employee.setId(id);
		Employee updatedEmployee = service.updateEmployee(employee);
				return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
	}

}
