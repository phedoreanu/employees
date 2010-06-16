package com.adina.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.adina.objects.ClasaSalariu;
import com.adina.util.HibernateUtil;


public class ClasaSalariuDAO {

	@SuppressWarnings("unchecked")
	public List<ClasaSalariu> getAllClasaSalariu(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<ClasaSalariu> listClasaSalariu=null;
		try {
			transaction = session.beginTransaction();
			listClasaSalariu = session.createQuery("from ClasaSalariu").list();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
	   return listClasaSalariu;
	}
	
	public void insertClasaSalariu(int nrClasa) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ClasaSalariu cs=new ClasaSalariu();
		cs.setNrClasa(nrClasa);
		try {
			transaction = session.beginTransaction();
			session.save(cs);
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

	public void deleteClasaSalariu(long idClasaSalariu){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Object cls=session.load(ClasaSalariu.class, idClasaSalariu);
		try {
			transaction = session.beginTransaction();
			session.delete(cls);
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
