package com.adina.objects;


import java.util.Date;

public class AngajatLocAnterior  implements java.io.Serializable {


     private Long idAngajatLoc;
     private Angajat angajat;
     private LocMuncaAnterior locMuncaAnterior;
     private Date dataAngajare;
     private Date dataPlecare;

    public AngajatLocAnterior() {
    }

    public AngajatLocAnterior(Angajat angajat, LocMuncaAnterior locMuncaAnterior, Date dataAngajare, Date dataPlecare) {
       this.angajat = angajat;
       this.locMuncaAnterior = locMuncaAnterior;
       this.dataAngajare = dataAngajare;
       this.dataPlecare = dataPlecare;
    }
   
    public Long getIdAngajatLoc() {
        return this.idAngajatLoc;
    }
    
    public void setIdAngajatLoc(Long idAngajatLoc) {
        this.idAngajatLoc = idAngajatLoc;
    }
    public Angajat getAngajat() {
        return this.angajat;
    }
    
    public void setAngajat(Angajat angajat) {
        this.angajat = angajat;
    }
    public LocMuncaAnterior getLocMuncaAnterior() {
        return this.locMuncaAnterior;
    }
    
    public void setLocMuncaAnterior(LocMuncaAnterior locMuncaAnterior) {
        this.locMuncaAnterior = locMuncaAnterior;
    }
    public Date getDataAngajare() {
        return this.dataAngajare;
    }
    
    public void setDataAngajare(Date dataAngajare) {
        this.dataAngajare = dataAngajare;
    }
    public Date getDataPlecare() {
        return this.dataPlecare;
    }
    
    public void setDataPlecare(Date dataPlecare) {
        this.dataPlecare = dataPlecare;
    }




}


