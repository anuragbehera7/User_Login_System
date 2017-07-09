package com.ab.mvcApp.model.service.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.mvcApp.dto.register.RegisterDTO;
import com.ab.mvcApp.model.dao.update.UpdateDAO;


@Service
public class UpdateService {

	@Autowired
	private UpdateDAO updateDAO;
	
	public UpdateService() {
		System.out.println(this.getClass().getSimpleName()+" created");
	}
	
	public RegisterDTO updateUserService(RegisterDTO dto){
		
		System.out.println("updateUserService STARTS");
		
		RegisterDTO dtoFromSession= updateDAO.updateUserDAO(dto);
		
		System.out.println("updateUserSetrvice END");
		
		return dtoFromSession;
	}
}
