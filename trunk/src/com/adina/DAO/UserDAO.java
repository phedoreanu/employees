package com.adina.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adina.objects.Users;
import com.adina.util.HibernateUtil;


public class UserDAO {

	@SuppressWarnings("unchecked")
	public List<Users> getAllUsers(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Users> listUser=null;
		try {
			transaction = session.beginTransaction();
			listUser = session.createQuery("from User").list();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
	   return listUser;
	}
	
	public void insertUser(String username, String password, String role) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Users u=new Users();
		u.setUsername(username);
		u.setPassword(password);
		try {
			transaction = session.beginTransaction();
			session.save(u);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return;
	}
	
	public void deleteUser(long idUser){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Object u=session.get(Users.class, idUser);
		try {
			transaction = session.beginTransaction();
			session.delete(u);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return;
	}
	
	public void updateUser(long idUser, String numeUser, String parola, String rol){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Users u=(Users)session.load(Users.class, idUser);
		try {
			transaction = session.beginTransaction();
			if (u != null){
				u.setUsername(numeUser);
				u.setPassword(parola);
				session.update(u);
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return;
	}
}
