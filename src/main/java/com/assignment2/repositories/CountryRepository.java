package com.assignment2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment2.entities.CountryMasterEntity;

public interface CountryRepository extends JpaRepository<CountryMasterEntity,Integer>{

}
