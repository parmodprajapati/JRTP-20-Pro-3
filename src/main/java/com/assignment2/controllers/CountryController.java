package com.assignment2.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.assignment2.services.CountryService;


@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	/*
	@GetMapping("/countries")
	ResponseEntity<List<CountryMasterEntity>> getAllCountries(){
		List<CountryMasterEntity> list = countryService.findAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}*/
	
	/*
	@GetMapping("/countries")
	public Map<Integer,String> getAllCountries(){
		return countryService.findAll();
	}*/
	
	@GetMapping("/countries")
	ResponseEntity<Map<Integer,String>> getAllCountries(){
		Map<Integer,String> list = countryService.findAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
}
