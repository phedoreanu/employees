package com.adina.objects;

import java.util.HashSet;
import java.util.Set;


public class Abilitate  implements java.io.Serializable {


     private Long idAbilitate;
     private String numeAbilitate;
     private Set angajatAbilitates = new HashSet(0);

    public Abilitate() {
    }

	
    public Abilitate(String numeAbilitate) {
        this.numeAbilitate = numeAbilitate;
    }
    public Abilitate(String numeAbilitate, Set angajatAbilitates) {
       this.numeAbilitate = numeAbilitate;
       this.angajatAbilitates = angajatAbilitates;
    }
   
    public Long getIdAbilitate() {
        return this.idAbilitate;
    }
    
    public void setIdAbilitate(Long idAbilitate) {
        this.idAbilitate = idAbilitate;
    }
    public String getNumeAbilitate() {
        return this.numeAbilitate;
    }
    
    public void setNumeAbilitate(String numeAbilitate) {
        this.numeAbilitate = numeAbilitate;
    }
    public Set getAngajatAbilitates() {
        return this.angajatAbilitates;
    }
    
    public void setAngajatAbilitates(Set angajatAbilitates) {
        this.angajatAbilitates = angajatAbilitates;
    }




}


