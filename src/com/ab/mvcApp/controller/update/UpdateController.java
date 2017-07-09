package com.ab.mvcApp.controller.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ab.mvcApp.dto.register.RegisterDTO;
import com.ab.mvcApp.model.service.update.UpdateService;

@Controller
@RequestMapping("/")
public class UpdateController {
	
	@Autowired
	private UpdateService service;
	
	public UpdateController() {
		System.out.println(this.getClass().getSimpleName());
	}
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public ModelAndView updateUserDetails(RegisterDTO dto,HttpServletRequest req)
	{
		
		System.out.println("in updateUserDetails()");
		
		HttpSession session=req.getSession(false);
		RegisterDTO dtoFromSession=(RegisterDTO) session.getAttribute("dto");
		
		int pk=dtoFromSession.getId();
		dto.setId(pk);
		
		
		RegisterDTO dtoFromdb= service.updateUserService(dto);
		if (dtoFromdb!=null) {
			session.setAttribute("dto", dtoFromdb);
			System.out.println("update controller starts");
			return new ModelAndView("Home.jsp","msg","Successfully Updated");
		}
		else
		return new ModelAndView("Update.jsp");
		
	}
	
}
