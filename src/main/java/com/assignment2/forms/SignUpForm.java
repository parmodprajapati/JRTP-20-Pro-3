package com.assignment2.forms;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpForm {
	private String firstName;
	private String lastName;
	private String emailId;
	private String phno;
	private LocalDate dob;
	private String gender;
	private int countryId; 
	private int stateId; 
	private int cityId; 
}
