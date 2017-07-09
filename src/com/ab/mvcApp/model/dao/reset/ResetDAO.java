package com.ab.mvcApp.model.dao.reset;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ResetDAO {

	@Autowired
	private SessionFactory factory;
	
	public ResetDAO() {
		System.out.println(this.getClass().getSimpleName()+" created");
	}
	
	public String validateEmail(String emailId){
		
		System.out.println("reset validateEmail START");
		
		String hql="select R.name From RegisterDTO R where R.emailId=:em";
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Query qry=session.createQuery(hql);
		qry.setParameter("em", emailId);
		String name=(String) qry.uniqueResult();
		return name;
	}
	
	public int resetDAO(String emailId,String password){
		System.out.println("resetDAO starts");
		
		String hql="update RegisterDTO R set R.password=:pw,R.confirmPwd=:cp where R.emailId=:em";
		Session session=factory.openSession();
		
		Query qry=session.createQuery(hql);
		qry.setParameter("pw", password);
		qry.setParameter("cp", password);
		qry.setParameter("em", emailId);
		int a=qry.executeUpdate();
		Transaction tx=session.beginTransaction();
		tx.commit();
		
		return a;
	}







}
