package com.assignment2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment2.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	public Optional<UserEntity> findByEmailId(String email);
	public Optional<UserEntity> findByEmailIdAndPassword(String email,String pass);
	
}
