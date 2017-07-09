package com.ab.mvcApp.model.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.mvcApp.dto.login.LoginDTO;
import com.ab.mvcApp.dto.register.RegisterDTO;
import com.ab.mvcApp.model.dao.login.LoginDAO;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO dao;
	
	public LoginService() {
		System.out.println(this.getClass().getSimpleName()+" created");
	}
	
	public RegisterDTO userLoginService(LoginDTO dto){
		System.out.println("userLoginService START");
		
		RegisterDTO dtoFomdb=dao.fetch(dto);
		
		System.out.println("userLoginService END");
		return dtoFomdb;
	}
}
