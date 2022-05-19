package com.assignment2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.assignment2.entities.UserEntity;
import com.assignment2.forms.LoginForm;
import com.assignment2.forms.SignUpForm;
import com.assignment2.forms.UnlockAccountForm;
import com.assignment2.services.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/check-email/{email}")
	public ResponseEntity<String> checkEmail(@PathVariable String email){
		String status = "Not available";
		UserEntity user = userService.findUserByEmailId(email);
		if(user==null) {
			status = "Available";
		}
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@PostMapping("/userRegistration")
	public ResponseEntity<String> userRegistration(@RequestBody SignUpForm user) {
		String signUpForm = userService.signUpForm(user);
		return new ResponseEntity<>(signUpForm,HttpStatus.OK);
	}
	
	@PostMapping("/unlock-account")
	public ResponseEntity<String> userUnlockAccount(@RequestBody UnlockAccountForm user) {
		String unlock = userService.unlockUserByEmailId(user);
		return new ResponseEntity<>(unlock,HttpStatus.OK);
	}
	
	@GetMapping("/forget-pass/{email}")
	public ResponseEntity<String> forgetPassword(@PathVariable String email){
		String status = userService.forgetPassword(email);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> userUnlockAccount(@RequestBody LoginForm user) {
		String status = userService.checkLogin(user);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
}
