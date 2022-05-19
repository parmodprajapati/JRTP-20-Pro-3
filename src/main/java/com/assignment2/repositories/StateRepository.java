package com.assignment2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment2.entities.StateMasterEntity;

public interface StateRepository extends JpaRepository<StateMasterEntity, Integer>{
	public List<StateMasterEntity> findByCountryId(int countryId);
}
