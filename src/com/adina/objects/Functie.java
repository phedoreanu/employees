package com.adina.objects;

import java.util.HashSet;
import java.util.Set;

public class Functie  implements java.io.Serializable {


     private Long idFunctie;
     private String numeFunctie;
     private Set angajats = new HashSet(0);

    public Functie() {
    }

	
    public Functie(String numeFunctie) {
        this.numeFunctie = numeFunctie;
    }
    public Functie(String numeFunctie, Set angajats) {
       this.numeFunctie = numeFunctie;
       this.angajats = angajats;
    }
   
    public Long getIdFunctie() {
        return this.idFunctie;
    }
    
    public void setIdFunctie(Long idFunctie) {
        this.idFunctie = idFunctie;
    }
    public String getNumeFunctie() {
        return this.numeFunctie;
    }
    
    public void setNumeFunctie(String numeFunctie) {
        this.numeFunctie = numeFunctie;
    }
    public Set getAngajats() {
        return this.angajats;
    }
    
    public void setAngajats(Set angajats) {
        this.angajats = angajats;
    }




}


