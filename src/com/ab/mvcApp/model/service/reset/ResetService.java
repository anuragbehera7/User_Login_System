package com.ab.mvcApp.model.service.reset;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.ab.mvcApp.model.dao.reset.ResetDAO;

@Service
public class ResetService {

	@Autowired
	private ResetDAO dao;
	
	@Autowired
	private JavaMailSenderImpl sender;
	
	public ResetService() {
		System.out.println(this.getClass().getSimpleName()+" created");
	}
	
	public String validateEmail(String emailId){
		System.out.println("reset service STARTS");
		String name=dao.validateEmail(emailId);
		System.out.println("reset Service END");
		return name;
	}
	
	public boolean resetService(String emailId){
		String password = UUID.randomUUID().toString().substring(0, 6).replaceAll("-", "");
		int a=dao.resetDAO(emailId, password);
		
		if (a!=0) {
			SimpleMailMessage message=new SimpleMailMessage();			
			message.setTo("imanurag08@gmail.com");
			message.setFrom("imanurag08@gmail.com");
			message.setSubject("Reset Password");
			message.setText("Hello user \t Your new Password is "+ password);
			sender.send(message);
			
			System.out.println("mail Sent");
			return true;
		}
		else {
			System.out.println("Not sent");
			return false;
		}
	}

}
