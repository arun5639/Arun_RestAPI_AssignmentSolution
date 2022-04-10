package com.Learning.EmployeeService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Learning.EmployeeService.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
