package com.adina.DAO;

import com.adina.bean.LocMuncaAnteriorBean;
import com.adina.objects.LocMuncaAnterior;
import com.adina.vo.LocMuncaAnteriorVO;

import java.util.List;
import com.adina.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LocMuncaAnteriorDAO {
    // private static final Logger LOG = Logger.getLogger(LocMuncaAnteriorController.class);

    public void fillPreviosWorkPlaceBean(LocMuncaAnteriorBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Long idWorkPlace = bean.getId();
            if (idWorkPlace != null) {
                LocMuncaAnterior workPlace = (LocMuncaAnterior) session.get(LocMuncaAnterior.class, idWorkPlace);
                bean.setName(workPlace.getNumeLoc());
            } else {
                bean.setWorkPlaceList(getAllPreviousWorkPlaces());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<LocMuncaAnteriorVO> getAllPreviousWorkPlaces() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<LocMuncaAnteriorVO> workPlaceList = null;

        try {
            transaction = (Transaction) session.beginTransaction();
            workPlaceList = session.createQuery("select new com.adina.vo.LocMuncaAnteriorVO(idLocMunca, numeLoc) from LocMuncaAnterior").list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return workPlaceList;
    }

    public void insertWorkPlace(LocMuncaAnteriorBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = (Transaction) session.beginTransaction();
            LocMuncaAnterior workPlace = new LocMuncaAnterior();
            workPlace.setNumeLoc(bean.getName());
            session.save(workPlace);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateWorkPlace(LocMuncaAnteriorBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = (Transaction) session.beginTransaction();
            Long id = bean.getId();

            if (id != null) {
                LocMuncaAnterior workPlace = (LocMuncaAnterior) session.get(LocMuncaAnterior.class, id);
                workPlace.setNumeLoc(bean.getName());
                session.update(workPlace);
                transaction.commit();
            } else {
                //LOG.error("No work place id!");
            }
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteWorkPlace(LocMuncaAnteriorBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = (Transaction) session.beginTransaction();
            Long id = bean.getId();

            if (id != null) {
                LocMuncaAnterior workPlace = (LocMuncaAnterior) session.get(LocMuncaAnterior.class, id);
                session.delete(workPlace);
                transaction.commit();
            } else {
                // LOG.error("No work place id!");
            }
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

