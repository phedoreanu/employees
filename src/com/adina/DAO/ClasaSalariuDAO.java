package com.adina.DAO;

import com.adina.bean.ClasaSalariuBean;
import com.adina.controller.ClasaSalariuController;
import java.util.List;
import javax.faces.model.SelectItem;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.adina.objects.ClasaSalariu;
import com.adina.util.HibernateUtil;
import com.adina.vo.ClasaSalariuVO;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.Query;

public class ClasaSalariuDAO {

    static final Logger LOG = Logger.getLogger(ClasaSalariuController.class);

    public void fillClasaSalariuBean(ClasaSalariuBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Long id = bean.getId();
            System.out.println("ID=" + id);
            if (id != null) {
                ClasaSalariu clsSalariu = (ClasaSalariu) session.get(ClasaSalariu.class, id);
                clsSalariu.setNrClasa(bean.getNrClasa());
            } else {
                bean.setClsSalariuList(getAllClasaSalariu());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<ClasaSalariuVO> getAllClasaSalariu() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<ClasaSalariuVO> listClasaSalariu = null;
        try {
            transaction = session.beginTransaction();
            listClasaSalariu = session.createQuery("select new com.adina.vo.ClasaSalariuVO(idClasaSalariu, nrClasa) from ClasaSalariu").list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listClasaSalariu;
    }

    List<SelectItem> getAllClasaSalariuAsSelectItems() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<SelectItem> listClasaSalariu = new ArrayList<SelectItem>();
        try {
            transaction = session.beginTransaction();
            Query userQuery = session.createQuery("select idClasaSalariu, nrClasa from ClasaSalariu");
            List<Object[]> results = userQuery.list();
            for (Object[] ob : results) {
                Long id = (Long) ob[0];
                Integer nrClasa = (Integer) ob[1];
                SelectItem si = new SelectItem(id, nrClasa.toString());
                listClasaSalariu.add(si);
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listClasaSalariu;
    }

    public void insertClasaSalariu(ClasaSalariuBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            ClasaSalariu clsSalariu = new ClasaSalariu();
            clsSalariu.setNrClasa(bean.getNrClasa());
            session.save(clsSalariu);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return;
    }

    public void deleteClasaSalariu(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            System.out.println("id=" + id);
            if (id != null) {
                ClasaSalariu clsSalariu = (ClasaSalariu) session.get(ClasaSalariu.class, id);
                session.delete(clsSalariu);
                transaction.commit();
            } else {
                LOG.error("No ClasaSalariu id!");
            }
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return;
    }
}
