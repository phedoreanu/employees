package com.adina.DAO;

import com.adina.bean.UserBean;
import com.adina.objects.UserRoles;

import com.adina.util.HibernateUtil;
import com.adina.vo.UserRolesVO;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserRolesDAO {

    public UserRolesDAO() {
    }

    public List<UserRolesVO> getAllUserRoles() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<UserRolesVO> userRolesList = null;
        try {
            transaction = session.beginTransaction();
            userRolesList = session.createQuery("select new com.adina.vo.UserRolesVO(id, username, role) from UserRoles").list();
            System.out.println("userRolesList= " + userRolesList);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userRolesList;
    }

    public void insertRole(UserBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            UserRoles userRoles = new UserRoles();
            userRoles.setUsername(bean.getUsername());
            userRoles.setRole(bean.getUserRole());
            session.save(userRoles);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateRole(UserBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Long id = bean.getId();
            if (id != null) {
                Query userRoleQuery = session.createQuery("select ur from UserRoles ur, Users u"
                        + " where u.id = :userId"
                        + " and u.username = ur.username");
                userRoleQuery.setLong("userId", id);

                UserRoles userRole = (UserRoles) userRoleQuery.uniqueResult();
                userRole.setUsername(bean.getUsername());
                userRole.setRole(bean.getUserRole());

                session.update(userRole);
                transaction.commit();
            }
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return;
    }

    public void deleteRole(UserRolesVO urVo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Integer id = urVo.getId();
            if (id != null) {
                UserRoles ur = (UserRoles) session.get(UserRoles.class, id);
                session.delete(ur);
                transaction.commit();
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
