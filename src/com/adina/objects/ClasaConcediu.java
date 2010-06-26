package com.adina.objects;

import java.util.HashSet;
import java.util.Set;


public class ClasaConcediu  implements java.io.Serializable {


     private Long idClasaConcediu;
     private int nrClasa;
     private Set angajats = new HashSet(0);

    public ClasaConcediu() {
    }

	
    public ClasaConcediu(int nrClasa) {
        this.nrClasa = nrClasa;
    }
    public ClasaConcediu(int nrClasa, Set angajats) {
       this.nrClasa = nrClasa;
       this.angajats = angajats;
    }
   
    public Long getIdClasaConcediu() {
        return this.idClasaConcediu;
    }
    
    public void setIdClasaConcediu(Long idClasaConcediu) {
        this.idClasaConcediu = idClasaConcediu;
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


