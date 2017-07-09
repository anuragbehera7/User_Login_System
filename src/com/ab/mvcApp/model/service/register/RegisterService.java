package com.ab.mvcApp.model.service.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ab.mvcApp.dto.register.RegisterDTO;
import com.ab.mvcApp.model.dao.register.RegisterDAO;

@Component
public class RegisterService {

	@Autowired
	private RegisterDAO registerDAO;
	
	public RegisterService() {
		System.out.println(this.getClass().getSimpleName()+" created");
	}
	
	public void createUser(RegisterDTO dto){
		System.out.println("createUser START in RegisterService");
		
		registerDAO.saveUser(dto);
		
		System.out.println("createUser END in RegisterService");
	}
	
}
