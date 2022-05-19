package com.assignment2.services;

import java.util.List;

import com.assignment2.entities.CityMasterEntity;

public interface CityService {
	String upsert(CityMasterEntity city);
	List<CityMasterEntity> findAll();
	CityMasterEntity findById(int id);
	List<CityMasterEntity> findByStateId(int stateId);
}
