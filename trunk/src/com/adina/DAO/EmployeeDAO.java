package com.adina.DAO;

import com.adina.bean.EmployeeBean;
import com.adina.objects.Angajat;
import com.adina.objects.Functie;
import com.adina.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDAO {

    public void insertEmployee(EmployeeBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Angajat angajat = new Angajat();
            angajat.setNume(bean.getName());

            Functie functie = new Functie();
            functie.setIdFunctie(bean.getFunctionId());

            angajat.setFunctie(functie);

            session.save(angajat);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
