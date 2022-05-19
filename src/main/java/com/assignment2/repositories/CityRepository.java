package com.assignment2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment2.entities.CityMasterEntity;

public interface CityRepository extends JpaRepository<CityMasterEntity, Integer>{
	
}
