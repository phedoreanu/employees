package com.adina.DAO;

import com.adina.bean.EmployeeBean;
import com.adina.controller.EmployeeController;
import com.adina.objects.Angajat;
import com.adina.objects.ClasaConcediu;
import com.adina.objects.ClasaSalariu;
import com.adina.objects.Functie;
import com.adina.objects.Users;
import com.adina.util.HibernateUtil;
import com.adina.vo.EmployeeVO;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDAO {

    private static final Logger LOG = Logger.getLogger(EmployeeController.class);

    public void fillEmployeeBean(EmployeeBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Long employeeId = bean.getAngajatId();

            if (employeeId != null) {
                Angajat employee = (Angajat) session.get(Angajat.class, employeeId);
                bean.setActiv(employee.getActiv());
                bean.setAdresa(employee.getAdresa());
                bean.setClasaConcediuId(employee.getClasaConcediu().getIdClasaConcediu());
                bean.setClasaSalariuId(employee.getClasaSalariu().getIdClasaSalariu());
                bean.setCnp(employee.getCnp());
                bean.setFunctieId(employee.getFunctie().getIdFunctie());
                bean.setName(employee.getNume());
                bean.setUserId(employee.getUsers().getIdUser());
            } else {
                bean.setEmployeesList(getAllEmployees());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<EmployeeVO> getAllEmployees() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<EmployeeVO> employeesList = null;
        try {
            transaction = session.beginTransaction();
            employeesList = session.createQuery("select new com.adina.vo.EmployeeVO(idAngajat, clasaConcediu, users, clasaSalariu, functie, nume, cnp, adresa, activ) from Angajat").list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeesList;

    }

    public void insertEmployee(EmployeeBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Angajat angajat = new Angajat();
            angajat.setNume(bean.getName());
            angajat.setActiv((byte) 0);
            angajat.setAdresa(bean.getAdresa());
            angajat.setCnp(bean.getCnp());
            Functie functie = new Functie();
            functie.setIdFunctie(bean.getFunctieId());
            angajat.setFunctie(functie);
            ClasaConcediu clsConcediu = new ClasaConcediu();
            clsConcediu.setIdClasaConcediu(bean.getClasaConcediuId());
            angajat.setClasaConcediu(clsConcediu);
            ClasaSalariu clsSalariu = new ClasaSalariu();
            clsSalariu.setIdClasaSalariu(bean.getClasaSalariuId());
            angajat.setClasaSalariu(clsSalariu);
            Users user = new Users();
            user.setIdUser(bean.getUserId());
            angajat.setUsers(user);

            session.save(angajat);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateEmployee(EmployeeBean bean) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void disableEmployee(EmployeeBean bean) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void addExtraInfo(EmployeeBean bean) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
