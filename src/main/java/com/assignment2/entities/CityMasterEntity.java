package com.assignment2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="city_master")
public class CityMasterEntity {
	@Id
	@Column(name="city_id")
	private int cityId;
	@Column(name="state_id")
	private int stateId;
	@Column(name="city_name")
	private String cityName;
}
