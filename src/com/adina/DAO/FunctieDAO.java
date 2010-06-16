package com.adina.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adina.objects.Functie;
import com.adina.util.HibernateUtil;


public class FunctieDAO {

	@SuppressWarnings("unchecked")
	public List<Functie> getAllFunctie(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Functie> listFunctie=null;
		try {
			transaction = session.beginTransaction();
			listFunctie = session.createQuery("from Functie").list();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
	   return listFunctie;
	}
	
	public void insertFunctie(String numeFunctie) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Functie f=new Functie();
		f.setNumeFunctie(numeFunctie);
		try {
			transaction = session.beginTransaction();
			session.save(f);
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
	
	public void deleteFunctie(long idFunctie){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Object fct=session.load(Functie.class, idFunctie);
		try {
			transaction = session.beginTransaction();
			session.delete(fct);
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
	
	public void updateFunctie(long idFunctie, String numeFunctie){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Functie fct=(Functie)session.load(Functie.class, idFunctie);
		try {
			transaction = session.beginTransaction();
			fct.setNumeFunctie(numeFunctie);
			session.update(fct);
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
