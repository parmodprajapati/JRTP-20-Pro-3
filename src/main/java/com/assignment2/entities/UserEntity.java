package com.assignment2.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "user_detail")
@Data
public class UserEntity {
	@Id
	@GeneratedValue
	private int userId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String emailId;
	@Column(name = "phone_number")
	private String phno;
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "gender")
	private String gender;
	@Column(name = "country_id")
	private int countryId;
	@Column(name = "state_id")
	private int stateId;
	@Column(name = "city_id")
	private int cityId;
	@Column(name = "account_status")
	private boolean isUnlocked;
	@Column(name = "password")
	private String password;
	@Column(name = "creation_on", updatable = false)
	@CreationTimestamp
	private LocalDate createdOn;
	@Column(name = "updated_on")
	@UpdateTimestamp
	private LocalDate updatedOn;
}
