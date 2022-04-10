package com.Learning.EmployeeService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Learning.EmployeeService.Model.User;
import com.Learning.EmployeeService.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private final UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder bcryptEncoder;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User saveUser(User user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return this.userRepository.save(user);
	}
}
