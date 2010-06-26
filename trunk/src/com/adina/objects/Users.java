package com.adina.objects;

import java.util.HashSet;
import java.util.Set;


public class Users  implements java.io.Serializable {

     private Long idUser;
     private String username;
     private String password;
     private Set angajats = new HashSet(0);

    public Users() {
    }

	
    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public Users(String username, String password, Set angajats) {
       this.username = username;
       this.password = password;
       this.angajats = angajats;
    }
   
    public Long getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Set getAngajats() {
        return this.angajats;
    }
    
    public void setAngajats(Set angajats) {
        this.angajats = angajats;
    }




}


