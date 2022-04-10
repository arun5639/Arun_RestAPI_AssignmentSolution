package com.Learning.EmployeeService.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Learning.EmployeeService.Model.Employee;
import com.Learning.EmployeeService.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee save(Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	public List<Employee> findAll(){
		return this.employeeRepository.findAll();
	}
	
	public Employee findEmployeeById(long employeeId) {
		return this.employeeRepository.findById(employeeId).orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id"));
	}
	
	public void deleteEmployeeById(long employeeId) {
		this.employeeRepository.deleteById(employeeId);
		
	}

	public List<Employee> findEmployeeByFirstname(String firstName) {
		return this.employeeRepository.findByFirstNameContainingAllIgnoreCase((String)firstName);
	}
	
	public List<Employee> findByFirstnameOrderByAsc(){
		return this.employeeRepository.findAllByOrderByFirstNameAsc();
	}
	
	public List<Employee> findByFirstnameOrderByDesc(){
		return this.employeeRepository.findAllByOrderByFirstNameDesc();
	}
}
