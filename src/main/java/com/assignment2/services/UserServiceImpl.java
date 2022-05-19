package com.assignment2.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment2.entities.UserEntity;
import com.assignment2.forms.LoginForm;
import com.assignment2.forms.SignUpForm;
import com.assignment2.forms.UnlockAccountForm;
import com.assignment2.repositories.UserRepository;
import com.assignment2.utility.EmailUtility;
import com.assignment2.utility.GeneratePassword;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	EmailUtility emailUtility;
	
	@Override
	public UserEntity findUserByEmailId(String email) {
		Optional<UserEntity> user = userRepo.findByEmailId(email);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public String signUpForm(SignUpForm signUp) {
		UserEntity user = new UserEntity();
		BeanUtils.copyProperties(signUp, user);		
		String tempPass = GeneratePassword.getTempPass();
		user.setPassword(tempPass);
		user.setUnlocked(false);
		UserEntity saveUser = userRepo.save(user);
		if(saveUser==null) {
			return "ERROR";
		}
		String subject = "Registration";
		String fileName="signup-mail.txt";
		String mailBody=readMailContents(fileName, user);		
		
		boolean sendMail = emailUtility.sendMail(user.getEmailId(), subject, mailBody);
		if(sendMail) {
			return "SUCCESS";
		}
		
		return "FAILURE";
	}

	@Override
	public String unlockUserByEmailId(UnlockAccountForm unlockAcc) {
	
		if(unlockAcc.getNewPass()!= unlockAcc.getConfirmPass()) {
			return "Please check new and confirm password";
		}
		
		// find user by email id
		Optional<UserEntity> user = userRepo.findByEmailId(unlockAcc.getEmail());
		if(user.isPresent()) {
			 UserEntity userEntity = user.get();
			 
			 if(userEntity.getPassword()!=unlockAcc.getTempPass()) {
				 return "Temp password not match";
			 }else {
				 //update account
				 UserEntity uaccount = findUserByEmailId(unlockAcc.getEmail());
				 uaccount.setUnlocked(true);
				 userRepo.save(uaccount);
				 return "unlock account";
			 }
		}
		return "account not exist"; // msg changed in controller based on msg.
	}

	@Override
	public String checkLogin(LoginForm loginForm) {
		Optional<UserEntity> checklogin = userRepo.findByEmailIdAndPassword(loginForm.getEmail(), loginForm.getPass());
		if(checklogin.isPresent()) {
			UserEntity user = checklogin.get();
			return user.isUnlocked()?"Unlocked account":"Locked account";
		}
		return "Email id and password does not match"; // msg based on string in controller.
	}

	@Override
	public String forgetPassword(String email) {
		UserEntity uaccount = findUserByEmailId(email);
		if(uaccount==null) {
			return "Account not exist";
		}
		
		String subject = "Forget Password";
		String fileName="forget-pass-mail.txt";
		String mailBody=readMailContents(fileName, uaccount);		
		
		boolean sendMail = emailUtility.sendMail(email, subject, mailBody);
		if(sendMail) {
			return "SUCCESS";
		}
		return "Failure";
	}

	@Override
	public UserEntity getUser(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	private String readMailContents(String fileName,UserEntity userEntity) {
		String body="";
		try {
			StringBuffer sb = new StringBuffer();
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line!=null) {
				sb.append(line);
				line = br.readLine();
			}
			body = sb.toString();
			body = body.replace("{firstName}", userEntity.getFirstName());
			body = body.replace("{lastName}", userEntity.getLastName());
			body = body.replace("{tempPass}", userEntity.getPassword());
			body = body.replace("{emailId}", userEntity.getEmailId());
			
			br.close();
		}catch(Exception ex) {
			System.out.println("Error caught: "+ex.getMessage());
		}
		return body;
	}
	/*
	@Override
	public String upsert(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity findUserByEmailId(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String unlockUserByEmailId(String tempPass,String confirmPass, String emailId, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatePassByEmailId(String pass, String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity getUser(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity checkLogin(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forgetPassword(String email) {
		// TODO Auto-generated method stub
		//send mail with auto generated password and save into db.
		//updatePassByEmailId
		return null;
	}
	*/

}
