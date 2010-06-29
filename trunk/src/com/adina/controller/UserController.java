package com.adina.controller;

import com.adina.DAO.UserDAO;
import com.adina.DAO.UserRolesDAO;
import com.adina.bean.UserBean;
import com.adina.util.FacesUtil;
import java.io.Serializable;


public class UserController implements Serializable {

    private UserDAO userDAO;
    private UserRolesDAO userRolesDAO;

    public UserController() {
        userDAO = new UserDAO();
        userRolesDAO = new UserRolesDAO();
    }

    public void fillUserBean(UserBean bean) {
        userDAO.fillUserBean(bean);
    }

    public String createAccount() {
        UserBean bean = (UserBean) FacesUtil.getBeanByName("userBean");
        userDAO.insertUser(bean);
        userRolesDAO.insertRole(bean);
        return "afterAccountOperations";
    }

    public String updateAccount() {
        UserBean bean = (UserBean) FacesUtil.getBeanByName("userBean");
        System.out.print("role in update controller: "+bean.getUserRole());
        userRolesDAO.updateRole(bean);
        userDAO.updateUser(bean);
        return "afterAccountOperations";
    }

    public String deleteAccount() {
        UserBean bean = (UserBean) FacesUtil.getBeanByName("userBean");
        userRolesDAO.deleteUserRole(bean);
        userDAO.deleteUser(bean);
        return "afterAccountOperations";
    }

    public String updateAdminPassw(){
         UserBean bean = (UserBean) FacesUtil.getBeanByName("userBean");
         userDAO.updateAdminPassw(bean);
         return "afterAdminUpdate";
    }
}

