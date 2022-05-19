package com.assignment2.services;

import java.util.Map;

import com.assignment2.entities.CountryMasterEntity;


public interface CountryService {
	String upsert(CountryMasterEntity country);
	Map<Integer,String> findAll();
	CountryMasterEntity findById(int id);
}
