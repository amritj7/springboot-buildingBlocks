package com.restservices.restservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restservices.restservices.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
