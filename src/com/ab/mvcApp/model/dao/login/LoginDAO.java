package com.ab.mvcApp.model.dao.login;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ab.mvcApp.dto.login.LoginDTO;
import com.ab.mvcApp.dto.register.RegisterDTO;

@Repository
public class LoginDAO {

	@Autowired
	private SessionFactory factory;
	
	public LoginDAO() {
		System.out.println(this.getClass().getSimpleName()+" created");
	}
	
	public RegisterDTO fetch(LoginDTO dto){
		System.out.println("loginDAO START");
		
		String hql="from RegisterDTO R where R.emailId=:em and R.password=:pwd";
		
		Session session=factory.openSession();
		Query qry=session.createQuery(hql);
		qry.setParameter("em", dto.getEmailid());
		qry.setParameter("pwd", dto.getPassword());
		
		RegisterDTO dtoFromdb=(RegisterDTO) qry.uniqueResult();
		
		System.out.println("loginDAO END");
		return dtoFromdb;
	}
}
