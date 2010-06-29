package com.adina.DAO;

import com.adina.bean.UserBean;
import com.adina.controller.UserController;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adina.objects.Users;
import com.adina.util.HibernateUtil;
import com.adina.util.MD5Digest;
import com.adina.vo.UserVO;
import javax.faces.model.SelectItem;
import org.apache.log4j.Logger;
import org.hibernate.Query;

public class UserDAO {

    private static final Logger LOG = Logger.getLogger(UserController.class);

    public void fillUserBean(UserBean bean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Long id = bean.getId();
            if (id != null) {
                Query userQuery = session.createQuery("select u.username, u.password, ur.role from Users u, UserRoles ur "
                        + "where u.username = ur.username "
                        + "and u.id = :userId");
                userQuery.setLong("userId", id);

                List<Object[]> results = userQuery.list();
                if (!results.isEmpty()) {
                    String username = (String) results.get(0)[0];
                    String password = (String) results.get(0)[1];
                    String role = (String) results.get(0)[2];
                    bean.setUsername(username);
                    bean.setPassword(password);
                    bean.setUserRole(role);
                }
            } else {
                bean.setUsers(getAllUsers());
            }

            Query rolesQuery = session.createQuery("select distinct role from UserRoles");
            List<String> roles = rolesQuery.list();

            if (!roles.isEmpty()) {
                for (String r : roles) {

                    Double randomId = Math.random() * 1000;
                    Long idRole = randomId.longValue();
                    SelectItem si = new SelectItem(idRole.toString(), r);
                    bean.getRoles().add(si);
                }
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
            String userRole = bean.getUserRole();
            System.out.println("userRole=" + userRole);
            u.setUsername(bean.getUsername());

            String originalPassword = bean.getPassword();
            try {
                String md5Password = MD5Digest.encodePassword(originalPassword);
                u.setPassword(md5Password);
            } catch (NoSuchAlgorithmException ex) {
                u.setPassword(originalPassword);
            }

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
