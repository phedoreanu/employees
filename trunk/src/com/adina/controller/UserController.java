package com.adina.controller;

import com.adina.DAO.UserDAO;
import com.adina.DAO.UserRolesDAO;
import com.adina.bean.UserBean;
import com.adina.util.FacesUtil;
import com.adina.vo.UserRolesVO;
import java.io.Serializable;
import java.util.List;

public class UserController implements Serializable {

    private UserDAO userDAO;
    private UserRolesDAO userRolesDAO;
    private UserRolesVO urVO;

    public UserController() {
        userDAO = new UserDAO();
        userRolesDAO = new UserRolesDAO();
    }

    public void fillPositionBean(UserBean bean) {
        userDAO.fillUserBean(bean);
    }

    public String createAccount() {
        UserBean bean = (UserBean) FacesUtil.getBeanByName("userBean");
        userDAO.insertUser(bean);
        userRolesDAO.insertRole(bean);
        getUserRolesByBean(bean);
        return "afterAccountOperations";
    }

    public String updateAccount() {
        UserBean bean = (UserBean) FacesUtil.getBeanByName("userBean");
        userDAO.updateUser(bean);
        userRolesDAO.updateRole(urVO, bean);
        return "afterAccountOperations";
    }

    public String deleteAccount() {
        UserBean bean = (UserBean) FacesUtil.getBeanByName("userBean");
        userDAO.deleteUser(bean);
        userRolesDAO.deleteRole(urVO);
        return "afterAccountOperations";
    }

    public void getUserRolesByBean(UserBean bean) {
        List<UserRolesVO> userRolesList = userRolesDAO.getAllUserRoles();
        for (UserRolesVO ur : userRolesList) {
            if (ur.getUsername().equals(bean.getUsername())) {
                urVO = new UserRolesVO(ur.getId(), ur.getUsername(), ur.getRole());
                break;
            }
        }
    }

    public String updateAdminPassw(){
         UserBean bean = (UserBean) FacesUtil.getBeanByName("userBean");
         userDAO.updateAdminPassw(bean);
         return "afterAdminUpdate";
    }
}

