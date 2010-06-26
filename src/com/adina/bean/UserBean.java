package com.adina.bean;

import com.adina.controller.UserController;
import com.adina.util.FacesUtil;
import com.adina.vo.UserVO;
import java.util.List;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.model.SelectItem;

public class UserBean implements Serializable {

    private Long id;
    private Long roleId;
    private String username;
    private String password;
    private String userRole;
    private List<UserVO> users;
    private List<SelectItem> roles;

    public UserBean() {
        try {
            //String id1 = FacesUtil.getRequestParameter("id");
            //setId(Long.parseLong(id1));
            Map<String, String> params=FacesUtil.getRequestParameters();
            Long id1=Long.parseLong(params.get("id"));
            setId(id1);
            String userName = (String)params.get("userName");
            setUsername(userName);
        } catch (NumberFormatException nfe) {
        }
        UserController userController = (UserController) FacesUtil.getBeanByName("userController");
        userController.fillPositionBean(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idUser) {
        this.id = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserVO> getUsers() {
        return users;
    }

    public void setUsers(List<UserVO> users) {
        this.users = users;
    }

    public List<SelectItem> getRoles() {
        if(roles == null) roles = new ArrayList<SelectItem>();
        return roles;
    }

    public void setRoles(List<SelectItem> roles) {
        this.roles = roles;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String role) {
        this.userRole = role;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


}
