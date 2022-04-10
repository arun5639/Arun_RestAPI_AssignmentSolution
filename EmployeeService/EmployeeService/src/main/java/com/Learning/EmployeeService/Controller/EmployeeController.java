package com.Learning.EmployeeService.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Learning.EmployeeService.Model.Employee;
import com.Learning.EmployeeService.Model.Role;
import com.Learning.EmployeeService.Model.User;
import com.Learning.EmployeeService.Service.EmployeeService;
import com.Learning.EmployeeService.Service.RoleService;
import com.Learning.EmployeeService.Service.UserService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	private final UserService userService;
	private final RoleService roleService;
	
	public EmployeeController(EmployeeService employeeService, UserService userService, RoleService roleService) {
		this.employeeService = employeeService;		
		this.userService = userService;
		this.roleService=roleService;
	}
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return this.userService.saveUser(user);
	}
	
	@PostMapping("/role")
	public Role saveRole(@RequestBody Role role) {
		return this.roleService.saveRole(role);
	}
	
	@GetMapping("/employees")
	public List<Employee> fetchAllEmployee() {
		return this.employeeService.findAll();
	}
	
	@GetMapping("employees/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") long empId) {
		return this.employeeService.findEmployeeById(empId);
	}
	
	@GetMapping("employees/search/{firstName}")
	public List<Employee> fetchEmployeeByFirstname(@PathVariable("firstName") String firstName){
		return this.employeeService.findEmployeeByFirstname(firstName);
	}
	
	@GetMapping("employees/sort")
	public List<Employee> fetchEmployeeByFirstnameByOrder(@RequestParam ("order") String order){
		
		if(order.equals("asc")) {
			return this.employeeService.findByFirstnameOrderByAsc();
		}
		else if(order.equals("desc")){
			return this.employeeService.findByFirstnameOrderByDesc();
		}
		else {
			return null;
		}
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return this.employeeService.save(employee);
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return this.employeeService.save(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteByEmployeeId(@PathVariable("id") long empId) {
		this.employeeService.deleteEmployeeById(empId);
		return "Deleted employee id - "+empId;
	}
}
