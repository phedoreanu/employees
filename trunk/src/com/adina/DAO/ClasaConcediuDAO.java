package com.adina.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adina.objects.ClasaConcediu;
import com.adina.util.HibernateUtil;


public class ClasaConcediuDAO {

	@SuppressWarnings("unchecked")
	public List<ClasaConcediu> getAllClasaConcediu(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<ClasaConcediu> listClasaConcediu=null;
		try {
			transaction = session.beginTransaction();
			listClasaConcediu = session.createQuery("from ClasaConcediu").list();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
	   return listClasaConcediu;
	}
	
	public void insertClasaConcediu(int nrClasa) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ClasaConcediu cc=new ClasaConcediu();
		cc.setNrClasa(nrClasa);
		try {
			transaction = session.beginTransaction();
			session.save(cc);
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
	
	public void deleteClasaConcediu(long idClasaConcediu){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Object cls=session.load(ClasaConcediu.class, idClasaConcediu);
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
