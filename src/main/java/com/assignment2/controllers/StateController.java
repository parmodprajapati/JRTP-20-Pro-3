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

import com.assignment2.entities.StateMasterEntity;
import com.assignment2.services.StateService;

@Controller
public class StateController {
	@Autowired
	private StateService stateService;
	
	@GetMapping("/states-by-country/{countryId}")
	ResponseEntity<Map<Integer,String>> listStatesByCountryId(@PathVariable int countryId){
		List<StateMasterEntity> list = stateService.findByCountryId(countryId);
		Map<Integer,String> stateList = list.stream()
				.collect(Collectors.toMap(StateMasterEntity::getStateId, 
						StateMasterEntity::getStateName));
		//or
		/*
		Map<Integer,String> listStates = list.stream()
				.collect(Collectors.toMap(s->s.getStateId(), s->s.getStateName()));
		*/
		return new ResponseEntity<>(stateList,HttpStatus.OK);
	}
}
