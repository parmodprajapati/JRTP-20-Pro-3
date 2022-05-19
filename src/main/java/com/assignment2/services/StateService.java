package com.assignment2.services;

import java.util.List;

import com.assignment2.entities.StateMasterEntity;

public interface StateService {
	String upsert(StateMasterEntity state);
	List<StateMasterEntity> findAll();
	StateMasterEntity findById(int id);
	List<StateMasterEntity> findByCountryId(int countryId);
}
