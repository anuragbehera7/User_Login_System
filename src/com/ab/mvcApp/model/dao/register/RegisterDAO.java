package com.ab.mvcApp.model.dao.register;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ab.mvcApp.dto.register.RegisterDTO;

@Component
public class RegisterDAO {
	@Autowired
	private SessionFactory factory;
	public RegisterDAO() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}
	
	public void saveUser(RegisterDTO dto){
		System.out.println("saveUser START in RegisterDAO");
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try {
			
			session.save(dto);
			tx.commit();
		} 
		catch (HibernateException he) 
		{
			he.printStackTrace();
			tx.rollback();
		}
		finally {
			session.close();
		}
		
		
		System.out.println("saveUser END in RegisterDAO");
	}

}
