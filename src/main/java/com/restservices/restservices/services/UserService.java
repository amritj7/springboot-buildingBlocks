package com.restservices.restservices.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restservices.restservices.entites.User;
import com.restservices.restservices.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();	
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> getUserById(Long userId) {
		 Optional<User> user = userRepository.findById(userId);
		 return user;
	}
	public User updateUserById(Long userId, User user) {
		user.setId(userId);
		return userRepository.save(user);
	}
	public String deleteUserById(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			return "User deleted Successfully!";
		}
		else 
			return "User not found!";
		
	}
}
