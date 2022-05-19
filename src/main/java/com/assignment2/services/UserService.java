package com.assignment2.services;

import com.assignment2.entities.UserEntity;
import com.assignment2.forms.LoginForm;
import com.assignment2.forms.SignUpForm;
import com.assignment2.forms.UnlockAccountForm;

public interface UserService {
/*	
	UserEntity findUserByEmailId(String email);
	
	String signUpForm(UserEntity user);	

	String unlockUserByEmailId(String tempPass, String confirmPass, String emailId, String newPass); 

	UserEntity checkLogin(UserEntity user);
	
	String forgetPassword(String email);

	UserEntity getUser(int uid);
*/
	UserEntity findUserByEmailId(String email);
	
	String signUpForm(SignUpForm signUp);	

	String unlockUserByEmailId(UnlockAccountForm unlockAcc); 

	String checkLogin(LoginForm loginForm);
	
	String forgetPassword(String email);

	UserEntity getUser(int uid);

	
}
