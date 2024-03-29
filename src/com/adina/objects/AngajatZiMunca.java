package com.adina.objects;


import java.util.Date;


public class AngajatZiMunca  implements java.io.Serializable {


     private Long idAngajatZi;
     private Angajat angajat;
     private Date ziua;
     private Integer nrOre;

    public AngajatZiMunca() {
    }

    public AngajatZiMunca(Angajat angajat, Date ziua, Integer nrOre) {
       this.angajat = angajat;
       this.ziua = ziua;
       this.nrOre = nrOre;
    }
   
    public Long getIdAngajatZi() {
        return this.idAngajatZi;
    }
    
    public void setIdAngajatZi(Long idAngajatZi) {
        this.idAngajatZi = idAngajatZi;
    }
    public Angajat getAngajat() {
        return this.angajat;
    }
    
    public void setAngajat(Angajat angajat) {
        this.angajat = angajat;
    }
    public Date getZiua() {
        return this.ziua;
    }
    
    public void setZiua(Date ziua) {
        this.ziua = ziua;
    }
    public Integer getNrOre() {
        return this.nrOre;
    }
    
    public void setNrOre(Integer nrOre) {
        this.nrOre = nrOre;
    }




}


