package com.adina.DAO;

import com.adina.bean.UserBean;
import com.adina.controller.UserController;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adina.objects.Users;
import com.adina.util.HibernateUtil;
import com.adina.vo.UserVO;
import org.apache.log4j.Logger;

public class UserDAO {

    private static final Logger LOG = Logger.getLogger(UserController.class);

    public void fillUserBean(UserBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Long id = bean.getId();
            if (id != null) {
                Users user = (Users) session.get(Users.class, id);
                bean.setUsername(user.getUsername());
                bean.setPassword(user.getPassword());
            } else {
                bean.setUsers(getAllUsers());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<UserVO> getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<UserVO> listUser = null;
        try {
            transaction = session.beginTransaction();
            listUser = session.createQuery("select new com.adina.vo.UserVO(idUser, username, password) from Users").list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listUser;
    }

    public void insertUser(UserBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Users u = new Users();
            u.setUsername(bean.getUsername());
            u.setPassword(bean.getPassword());
            session.save(u);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteUser(UserBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Long id = bean.getId();
            if (id != null) {
                Users u = (Users) session.get(Users.class, id);
                session.delete(u);
                transaction.commit();
            } else {
                LOG.error("No user id!");
            }
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return;
    }

    public void updateUser(UserBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Long id = bean.getId();
            if (id != null) {
                Users u = (Users) session.get(Users.class, id);
                u.setUsername(bean.getUsername());
                u.setPassword(bean.getPassword());
                session.update(u);
                transaction.commit();
            } else {
                LOG.error("No user id!");
            }
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return;
    }

    public void updateAdminPassw(UserBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String name = bean.getUsername();
            if (name != null) {
                Users u = (Users) session.get(Users.class, name);
                u.setPassword(bean.getPassword());
                session.update(u);
                transaction.commit();
            } else {
                LOG.error("No user id!");
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
