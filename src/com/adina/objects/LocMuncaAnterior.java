package com.adina.objects;


import java.util.HashSet;
import java.util.Set;


public class LocMuncaAnterior  implements java.io.Serializable {


     private Long idLocMunca;
     private String numeLoc;
     private Set angajatLocAnteriors = new HashSet(0);

    public LocMuncaAnterior() {
    }

	
    public LocMuncaAnterior(String numeLoc) {
        this.numeLoc = numeLoc;
    }
    public LocMuncaAnterior(String numeLoc, Set angajatLocAnteriors) {
       this.numeLoc = numeLoc;
       this.angajatLocAnteriors = angajatLocAnteriors;
    }
   
    public Long getIdLocMunca() {
        return this.idLocMunca;
    }
    
    public void setIdLocMunca(Long idLocMunca) {
        this.idLocMunca = idLocMunca;
    }
    public String getNumeLoc() {
        return this.numeLoc;
    }
    
    public void setNumeLoc(String numeLoc) {
        this.numeLoc = numeLoc;
    }
    public Set getAngajatLocAnteriors() {
        return this.angajatLocAnteriors;
    }
    
    public void setAngajatLocAnteriors(Set angajatLocAnteriors) {
        this.angajatLocAnteriors = angajatLocAnteriors;
    }




}


