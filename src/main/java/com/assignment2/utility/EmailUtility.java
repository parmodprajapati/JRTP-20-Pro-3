package com.assignment2.utility;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtility {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendMail(String emailTo, String subject, String body) {
		try {
			MimeMessage mime = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mime);
			
			helper.setTo(emailTo);
			helper.setSubject(subject);
			helper.setText(body,true);
			javaMailSender.send(mime);
			return true;
			
		}catch(Exception ex) {
			System.out.println("Error to send mail: "+ex.getMessage());
		}
		return false;
	}
}
