package com.adina.objects;

import java.util.HashSet;
import java.util.Set;


public class ClasaSalariu  implements java.io.Serializable {
     private Long idClasaSalariu;
     private int nrClasa;
     private Set angajats = new HashSet(0);

    public ClasaSalariu() {
    }

	
    public ClasaSalariu(int nrClasa) {
        this.nrClasa = nrClasa;
    }
    public ClasaSalariu(int nrClasa, Set angajats) {
       this.nrClasa = nrClasa;
       this.angajats = angajats;
    }
   
    public Long getIdClasaSalariu() {
        return this.idClasaSalariu;
    }
    
    public void setIdClasaSalariu(Long idClasaSalariu) {
        this.idClasaSalariu = idClasaSalariu;
    }
    public int getNrClasa() {
        return this.nrClasa;
    }
    
    public void setNrClasa(int nrClasa) {
        this.nrClasa = nrClasa;
    }
    public Set getAngajats() {
        return this.angajats;
    }
    
    public void setAngajats(Set angajats) {
        this.angajats = angajats;
    }




}


