package com.adina.DAO;

import com.adina.bean.ExtraInfoBean;
import com.adina.util.HibernateUtil;
import com.adina.vo.AngajatLocAnteriorVO;
import com.adina.vo.EmployeeVO;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ExtraInfoDAO {

    public void fillExtraInfoBean(ExtraInfoBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;
        List<Object[]> employeesExtraList = null;
        try {
            transaction = session.beginTransaction();
            Query employeesExtraQuery = session.createQuery(
                    "select ala.dataAngajare, ala.dataPlecare, ala.locMuncaAnterior.idLocMunca, ala.locMuncaAnterior.numeLoc  "
                    + "from Angajat a, AngajatLocAnterior ala "
                    + "where a.idAngajat = :employeeId "
                    + "and a = ala.angajat");
            employeesExtraQuery.setLong("employeeId", bean.getIdAngajat());

            List<Object[]> results = employeesExtraQuery.list();
            System.out.println("results.size()=" + results.size());
            if (!results.isEmpty()) {
                for (Object[] object : results) {
                    AngajatLocAnteriorVO angajatLocAnteriorVO = new AngajatLocAnteriorVO();

                    angajatLocAnteriorVO.setIdAngajat(bean.getIdAngajat());
//                        angajatLocAnteriorVO.setIdAngajatLoc(angajatLocAnterior.getIdAngajatLoc());
                    angajatLocAnteriorVO.setDataAngajare((Date) object[0]);
                    angajatLocAnteriorVO.setDataPlecare((Date) object[1]);
                    angajatLocAnteriorVO.setIdLocMunca((Long) object[2]);
                    angajatLocAnteriorVO.setNumeLoc((String) object[3]);

                    bean.getLocuriAnterioare().add(angajatLocAnteriorVO);
                }
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void insertExtraInfo() {
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
    }
}
