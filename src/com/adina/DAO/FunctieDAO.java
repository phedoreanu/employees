package com.adina.DAO;

import com.adina.bean.FunctieBean;
import com.adina.controller.FunctieController;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adina.objects.Functie;
import com.adina.util.HibernateUtil;
import com.adina.vo.FunctieVO;
import javax.faces.model.SelectItem;
import org.apache.log4j.Logger;

public class FunctieDAO {

    private static final Logger LOG = Logger.getLogger(FunctieController.class);

    public void fillPositionBean(FunctieBean bean) {
         Session session = HibernateUtil.getSessionFactory().openSession();
         try{
             Long id = bean.getId();
             if (id != null){
                Functie fct = (Functie) session.get(Functie.class, id);
                bean.setName(fct.getNumeFunctie());
             }else{
                 bean.setPositions(getAllPositions());
             }
         }catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<FunctieVO> getAllPositions() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<FunctieVO> listFunctie = null;
        try {
            transaction = session.beginTransaction();
            listFunctie = session.createQuery("select new com.adina.vo.FunctieVO(idFunctie, numeFunctie) from Functie").list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listFunctie;
    }

    public List<SelectItem> getAllPositionsAsSelectItems() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<SelectItem> listFunctie = null;
        try {
            transaction = session.beginTransaction();
            listFunctie = session.createQuery("select new javax.faces.model.SelectItem(idFunctie, numeFunctie) from Functie").list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listFunctie;
    }

    public void insertFunctie(FunctieBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Functie f = new Functie();
            f.setNumeFunctie(bean.getName());
            session.save(f);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return;
    }

    public void deleteFunctie(FunctieBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Long id = bean.getId();
            if (id != null) {
                Functie fct = (Functie) session.get(Functie.class, id);
                session.delete(fct);
                transaction.commit();
            } else {
                LOG.error("No position id!");
            }
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return;
    }

    public void updateFunctie(FunctieBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Long id = bean.getId();
            if (id != null) {
                Functie fct = (Functie) session.get(Functie.class, id);
                fct.setNumeFunctie(bean.getName());
                session.update(fct);
                transaction.commit();
            } else {
                LOG.error("No position id!");
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
