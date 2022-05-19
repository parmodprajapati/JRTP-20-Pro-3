package com.assignment2.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment2.entities.CountryMasterEntity;
import com.assignment2.repositories.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryRepository countryRepo;
	
	@Override
	public String upsert(CountryMasterEntity country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer,String> findAll() {
		Map<Integer,String> list = new HashMap<Integer,String>();
		List<CountryMasterEntity> findAll = countryRepo.findAll();
		for(CountryMasterEntity c : findAll) {
			list.put(c.getId(), c.getCountryName());
		}
		return list;
	}

	@Override
	public CountryMasterEntity findById(int id) {
		return countryRepo.findById(id).get();
	}

}
