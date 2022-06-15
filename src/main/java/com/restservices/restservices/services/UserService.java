package com.restservices.restservices.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.restservices.restservices.entites.User;
import com.restservices.restservices.exceptions.UserExistException;
import com.restservices.restservices.exceptions.UserNotFoundException;
import com.restservices.restservices.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();	
	}
	
	public User createUser(User user) throws UserExistException {
		User existingUser = userRepository.findByUsername(user.getUsername());
		if(existingUser != null) {
			throw new UserExistException("User already exists with the given username!");
		}
		return userRepository.save(user);
	}
	
	public Optional<User> getUserById(Long userId) throws UserNotFoundException{
		 Optional<User> user = userRepository.findById(userId);
		 
		 if(!user.isPresent()) {
			 throw new UserNotFoundException("User Not Found in the Repository");
		 }
		 return user;
	}
	public User updateUserById(Long userId, User user) throws UserNotFoundException{
		Optional<User> optionalUser = userRepository.findById(userId);
		 if(!optionalUser.isPresent()) {
			 throw new UserNotFoundException("User Not Found in the Repository with the given id");
		 }
		 else {
			 user.setId(userId);
				return userRepository.save(user);
		 }
		
	}
	public void deleteUserById(Long id) {
		 Optional<User> optionalUser = userRepository.findById(id);
		 if(!optionalUser.isPresent()) {
			 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Not Found in the Repository with the given id");
		 }
		userRepository.deleteById(id);
	}
	public User getByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
