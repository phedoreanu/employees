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
import javax.faces.model.SelectItem;
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
                bean.setPositionId(employee.getFunctie().getIdFunctie());
                bean.setPositionName(employee.getFunctie().getNumeFunctie());
                bean.setName(employee.getNume());
                bean.setUserId(employee.getUsers().getIdUser());
            } else {
                //bean.setEmployeesList(getAllEmployees());
                bean.setEmployeesList(getAllEmployeesDetailNames());

                FunctieDAO functieDAO = new FunctieDAO();
                List<SelectItem> positions = functieDAO.getAllPositionsAsSelectItems();
                bean.setPositions(positions);

                UserDAO userDAO = new UserDAO();
                List<SelectItem> users = userDAO.getAllUsersAsSelectItems();
                bean.setUsers(users);

                ClasaConcediuDAO clsConcediuDAO = new ClasaConcediuDAO();
                List<SelectItem> clsConcediuList = clsConcediuDAO.getAllClasaConcediuAsSelectItems();
                bean.setHolidayClass(clsConcediuList);

                ClasaSalariuDAO clsSalariuDAO = new ClasaSalariuDAO();
                List<SelectItem> clsSalariuList = clsSalariuDAO.getAllClasaSalariuAsSelectItems();
                bean.setSalaryClass(clsSalariuList);
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

            employeesList = session.createQuery("select new com.adina.vo.EmployeeVO(idAngajat, clasaConcediu.id, users.id, clasaSalariu.id, functie.id, nume, cnp, adresa, activ) from Angajat").list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeesList;

    }

    public List<EmployeeVO> getAllEmployeesDetailNames() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<EmployeeVO> employeesList = null;
        try {
            transaction = session.beginTransaction();
            employeesList = session.createQuery("select new com.adina.vo.EmployeeVO(idAngajat, clasaConcediu.nrClasa, users.username, clasaSalariu.nrClasa, functie.numeFunctie, nume, cnp, adresa, activ) from Angajat").list();
            System.out.println("employeesList.size()=" + employeesList.size());
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
            if (bean.getPositionId() != null) {
                Functie functie = new Functie();
                Long idf = bean.getPositionId();
                functie.setIdFunctie(idf);
                /* FunctieDAO fctDAO = new FunctieDAO();
                String positionName = fctDAO.getPositionNameById(idf);
                functie.setNumeFunctie(positionName);*/
                angajat.setFunctie(functie);
            }

            if (bean.getClasaConcediuId() != null) {
                ClasaConcediu clsConcediu = new ClasaConcediu();
                clsConcediu.setIdClasaConcediu(bean.getClasaConcediuId());
                angajat.setClasaConcediu(clsConcediu);
            }

            if (bean.getClasaSalariuId() != null) {
                ClasaSalariu clsSalariu = new ClasaSalariu();
                clsSalariu.setIdClasaSalariu(bean.getClasaSalariuId());
                angajat.setClasaSalariu(clsSalariu);
            }

            if (bean.getUserId() != null) {
                Users user = new Users();
                user.setIdUser(bean.getUserId());
                angajat.setUsers(user);
            }

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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Long idAngajat = bean.getAngajatId();
            String name = bean.getName();
            String cnp = bean.getCnp();
            String adresa = bean.getAdresa();
            byte activ = bean.getActiv();
            Functie functie = new Functie();
            ClasaConcediu clsConcediu = new ClasaConcediu();
            ClasaSalariu clsSalariu = new ClasaSalariu();
            Users users = new Users();

            if (bean.getPositionId() != null) {
                functie.setIdFunctie(bean.getPositionId());
            }
            if (bean.getClasaConcediuId() != null) {
                clsConcediu.setIdClasaConcediu(bean.getClasaConcediuId());
            }
            if (bean.getClasaSalariuId() != null) {
                clsSalariu.setIdClasaSalariu(bean.getClasaSalariuId());
            }
            if (bean.getUserId() != null) {
                users.setIdUser(bean.getUserId());
            }
            if (idAngajat != null) {
                Angajat employee = (Angajat) session.get(Angajat.class, idAngajat);
                if (activ == 0) {
                    employee.setActiv((byte) 0);
                } else {
                    employee.setActiv((byte) 1);
                }
                employee.setAdresa(adresa);
                employee.setCnp(cnp);
                employee.setClasaConcediu(clsConcediu);
                employee.setClasaSalariu(clsSalariu);
                employee.setFunctie(functie);
                employee.setNume(name);
                employee.setUsers(users);
                session.update(employee);
                transaction.commit();
            } else {
                LOG.error("No employee id!");
            }

        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void disableEmployee(EmployeeBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Long idAngajat = bean.getAngajatId();
            if (idAngajat != null) {
                Angajat employee = (Angajat) session.get(Angajat.class, idAngajat);
                employee.setActiv((byte) 0);
                session.update(employee);
                transaction.commit();
            }
            else{
                LOG.error("No employee id!");
            }
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void addExtraInfo(EmployeeBean bean) {
        throw new UnsupportedOperationException("Not yet implemented");


    }
}
