package com.adina.DAO;

import com.adina.controller.ClasaConcediuController;
import com.adina.bean.ClasaConcediuBean;
import java.util.List;
import javax.faces.model.SelectItem;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adina.objects.ClasaConcediu;
import com.adina.util.HibernateUtil;
import com.adina.vo.ClasaConcediuVO;
import org.apache.log4j.Logger;

public class ClasaConcediuDAO {

    private static final Logger LOG = Logger.getLogger(ClasaConcediuController.class);

    public void fillClasaConcediuBean(ClasaConcediuBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Long id = bean.getId();
            System.out.println("IDClasaConcediu=" + id);
            if (id != null) {
                ClasaConcediu clsConcediu = (ClasaConcediu) session.get(ClasaConcediu.class, id);
                bean.setNrClasa(clsConcediu.getNrClasa());
            } else {
                bean.setClasaConcediuList(getAllClasaConcediu());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<ClasaConcediuVO> getAllClasaConcediu() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<ClasaConcediuVO> clsConcediuList = null;
        try {
            transaction = session.beginTransaction();
            clsConcediuList = session.createQuery("select new com.adina.vo.ClasaConcediuVO(idClasaConcediu, nrClasa) from ClasaConcediu").list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return clsConcediuList;
    }

    List<SelectItem> getAllClasaConcediuAsSelectItems() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<SelectItem> clsConcediuList = null;
        try {
            transaction = session.beginTransaction();
            clsConcediuList = session.createQuery("select new javax.faces.model.SelectItem(idClasaConcediu, nrClasa) from ClasaConcediu").list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return clsConcediuList;
    }

    public void insertClasaConcediu(ClasaConcediuBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            ClasaConcediu cc = new ClasaConcediu();
            cc.setNrClasa(bean.getNrClasa());
            session.save(cc);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteClasaConcediu(Long idXX) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            System.out.print("idClasaConcediu= "+idXX);
            if (idXX != null) {
                ClasaConcediu clsConcediu = (ClasaConcediu) session.get(ClasaConcediu.class, idXX);
                session.delete(clsConcediu);
                transaction.commit();
            }else{
                LOG.error("No clasaConcediu id!");
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
