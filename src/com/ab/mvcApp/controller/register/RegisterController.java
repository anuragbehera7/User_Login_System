package com.ab.mvcApp.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ab.mvcApp.dto.register.RegisterDTO;
import com.ab.mvcApp.model.service.register.RegisterService;

@Component
@RequestMapping("/")
public class RegisterController {

	@Autowired
	private RegisterService service;
	
	public RegisterController() {
		System.out.println(this.getClass().getSimpleName()+" created");
	}
	
	@RequestMapping(value="register.do")
	public ModelAndView registerUserController(RegisterDTO dto){
		
		System.out.println("user register controller starts...");
		service.createUser(dto);
		System.out.println("user register controller ends");
		
		return new ModelAndView("Success.jsp","nm",dto.getName());
	}
	
}
