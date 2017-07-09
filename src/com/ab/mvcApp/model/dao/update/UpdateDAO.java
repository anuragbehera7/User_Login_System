package com.ab.mvcApp.model.dao.update;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ab.mvcApp.dto.register.RegisterDTO;

@Repository
public class UpdateDAO {

	@Autowired
	private SessionFactory factory;
	
	public UpdateDAO() {
		
		System.out.println(this.getClass().getSimpleName()+" created");
	}
	
	public RegisterDTO updateUserDAO(RegisterDTO dto){
		
		System.out.println("updateUserDAO START");
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		RegisterDTO dtoFromdb =(RegisterDTO) session.merge(dto);
		try {
			
			tx.commit();
			
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		}
		finally {
			session.close();
		}
		
		System.out.println("updateUserDAO END....");
		return dtoFromdb;
		
	}

	
	
	
	
	
	
	
	
}
