package com.assignment2.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.assignment2.entities.CityMasterEntity;
import com.assignment2.services.CityService;

@Controller
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("/cities-by-state/{stateId}")
	ResponseEntity<Map<Integer,String>> listCitiesByStateId(@PathVariable int stateId){
		List<CityMasterEntity> list = cityService.findByStateId(stateId);
		Map<Integer,String> cityList = list.stream()
				.collect(Collectors.toMap(CityMasterEntity::getCityId, 
						CityMasterEntity::getCityName));
		//or
		/*
		Map<Integer,String> listCities = list.stream()
				.collect(Collectors.toMap(s->s.getCityId(), s->s.getCityName()));
		*/
		return new ResponseEntity<>(cityList,HttpStatus.OK);
	}
	
}
