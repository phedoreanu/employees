package com.adina.bean;

import java.util.List;

import com.adina.DAO.UserDAO;
import com.adina.objects.Users;

public class UserBean {
	private Long idUser;
    private String username;
    private String password;
    
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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
    
    public String checkUserByNameAndPass(){
    	UserDAO userDAO=new UserDAO();
    	List<Users> listUsers = null;
    	try{
    		listUsers=userDAO.getAllUsers();
    	}
    	catch(Exception e){}
    	for (Users u:listUsers){
    		if (u.getUsername().equals(username) && u.getPassword().equals(password))
    			return "success";
    	}
    	return "failure";
    }
}
