package com.assignment2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="country_master")
@Data
public class CountryMasterEntity {
	@Id
	@Column(name="country_id")
	private int id;
	
	@Column(name="country_name")
	private String countryName;
}
