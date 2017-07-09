package com.ab.mvcApp.controller.reset;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ab.mvcApp.model.service.reset.ResetService;

@Controller
@RequestMapping("/")
public class ResetController {

	@Autowired
	private ResetService service;
	
	public ResetController() {
		System.out.println(this.getClass().getSimpleName()+" created");
	}
	
	@RequestMapping(value="/forgot.do",method=RequestMethod.POST)
	public ModelAndView validateEmail(@RequestParam String emailId){
		
		System.out.println("validateEmail STARTS");
		String name=service.validateEmail(emailId);
		
		if (name!=null) {
			System.out.println("reset end");
			return new ModelAndView("redirect:reset.do?em="+emailId);
		}
		else {
			System.out.println("reset end");
			return new ModelAndView("Reset.jsp","msg","Not Registered");
		}
	}
	
	@RequestMapping(value="reset.do")
	public ModelAndView resetpwd(HttpServletRequest req){
		
		String emailId=req.getParameter("em");
		boolean password=service.resetService(emailId);
		
		return new ModelAndView("Reset.jsp","pwd",password);
	}
	
	
}
