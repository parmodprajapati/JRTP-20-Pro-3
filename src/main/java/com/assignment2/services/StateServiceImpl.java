package com.assignment2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment2.entities.StateMasterEntity;
import com.assignment2.repositories.StateRepository;

@Service
public class StateServiceImpl implements StateService{

	@Autowired
	private StateRepository stateRepo;
	
	@Override
	public String upsert(StateMasterEntity state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateMasterEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateMasterEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateMasterEntity> findByCountryId(int countryId) {
		return stateRepo.findByCountryId(countryId);
	}

}
