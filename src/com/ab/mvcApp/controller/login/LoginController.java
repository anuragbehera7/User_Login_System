package com.ab.mvcApp.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ab.mvcApp.dto.login.LoginDTO;
import com.ab.mvcApp.dto.register.RegisterDTO;
import com.ab.mvcApp.model.service.login.LoginService;

@Controller
@RequestMapping
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	public LoginController() {
		System.out.println(this.getClass().getSimpleName()+" created");
	}
	
	@RequestMapping(value="/Login.do",method=RequestMethod.POST)
	public ModelAndView userLoginController(LoginDTO dto,HttpServletRequest req){
		System.out.println("loginController START");
		
		RegisterDTO dtoFromdb = service.userLoginService(dto);
		
		if(dtoFromdb!=null){
			System.out.println("login success");
			
			HttpSession session=req.getSession();
			session.setAttribute("dto", dtoFromdb);
			
			return new ModelAndView("Home.jsp","nmg",dtoFromdb.getName());
		}
		
		else
		System.out.println("loginController END");
		return new ModelAndView("Login.jsp","msg","Invalid Credentials");
	}
}
