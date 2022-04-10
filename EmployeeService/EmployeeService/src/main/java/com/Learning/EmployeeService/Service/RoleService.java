package com.Learning.EmployeeService.Service;

import org.springframework.stereotype.Service;

import com.Learning.EmployeeService.Model.Role;
import com.Learning.EmployeeService.Repository.RoleRepository;

@Service
public class RoleService {
	
	private final RoleRepository roleRepository;

	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public Role saveRole(Role role) {
		System.out.println("Role "+ role.toString());
		return this.roleRepository.save(role);
	}
}
