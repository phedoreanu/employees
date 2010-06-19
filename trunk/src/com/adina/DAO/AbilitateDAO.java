package com.adina.DAO;

import com.adina.bean.AbilitateBean;
import com.adina.controller.AbilitateController;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adina.objects.Abilitate;
import com.adina.util.HibernateUtil;
import com.adina.vo.AbilitateVO;
import org.apache.log4j.Logger;

public class AbilitateDAO {

    private static final Logger LOG = Logger.getLogger(AbilitateController.class);

    public void fillAbilityBean(AbilitateBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Long idAbility = bean.getId();

            if (idAbility != null) {
                Abilitate abil = (Abilitate) session.get(Abilitate.class, idAbility);
                bean.setName(abil.getNumeAbilitate());
            } else {
                bean.setAbilities(getAllAbilities());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<AbilitateVO> getAllAbilities() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<AbilitateVO> listAbilitate = null;
        try {
            transaction = session.beginTransaction();
            listAbilitate = session.createQuery("select new com.adina.vo.AbilitateVO(idAbilitate, numeAbilitate) from Abilitate").list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listAbilitate;
    }

    public void insertAbilitate(AbilitateBean abilitateBean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        System.out.println("numele este "+abilitateBean.getName());
        try {
            transaction = session.beginTransaction();
            Abilitate abil = new Abilitate();
            abil.setNumeAbilitate(abilitateBean.getName());
            session.save(abil);
            transaction.commit();

        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateAbilitate(AbilitateBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Long idAbilitate = bean.getId();
            System.out.println("idAbilitate=" + idAbilitate);
            String name = bean.getName();

            if (idAbilitate != null) {
                Abilitate abil = (Abilitate) session.get(Abilitate.class, idAbilitate);
                abil.setNumeAbilitate(name);
                session.update(abil);
                transaction.commit();
            } else {
                LOG.error("No abilitate id!");
            }

        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteAbilitate(AbilitateBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Long idAbilitate = bean.getId();
            System.out.println("idAbilitate=" + idAbilitate);

            if (idAbilitate != null) {
                Abilitate abil = (Abilitate) session.get(Abilitate.class, idAbilitate);
                session.delete(abil);
                transaction.commit();
            } else {
                LOG.error("No abilitate id!");
            }

        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
