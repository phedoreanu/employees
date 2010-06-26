package com.adina.objects;

public class UserRoles  implements java.io.Serializable {


     private Integer id;
     private String username;
     private String role;

    public UserRoles() {
    }

    public UserRoles(String username, String role) {
       this.username = username;
       this.role = role;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

}


