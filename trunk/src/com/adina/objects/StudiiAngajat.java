package com.adina.objects;



import java.util.Date;

public class StudiiAngajat  implements java.io.Serializable {


     private Long idStudiiAngajat;
     private Angajat angajat;
     private String numeInstitut;
     private String tipStudiu;
     private Date dataAbsolvire;

    public StudiiAngajat() {
    }

	
    public StudiiAngajat(String numeInstitut, String tipStudiu, Date dataAbsolvire) {
        this.numeInstitut = numeInstitut;
        this.tipStudiu = tipStudiu;
        this.dataAbsolvire = dataAbsolvire;
    }
    public StudiiAngajat(Angajat angajat, String numeInstitut, String tipStudiu, Date dataAbsolvire) {
       this.angajat = angajat;
       this.numeInstitut = numeInstitut;
       this.tipStudiu = tipStudiu;
       this.dataAbsolvire = dataAbsolvire;
    }
   
    public Long getIdStudiiAngajat() {
        return this.idStudiiAngajat;
    }
    
    public void setIdStudiiAngajat(Long idStudiiAngajat) {
        this.idStudiiAngajat = idStudiiAngajat;
    }
    public Angajat getAngajat() {
        return this.angajat;
    }
    
    public void setAngajat(Angajat angajat) {
        this.angajat = angajat;
    }
    public String getNumeInstitut() {
        return this.numeInstitut;
    }
    
    public void setNumeInstitut(String numeInstitut) {
        this.numeInstitut = numeInstitut;
    }
    public String getTipStudiu() {
        return this.tipStudiu;
    }
    
    public void setTipStudiu(String tipStudiu) {
        this.tipStudiu = tipStudiu;
    }
    public Date getDataAbsolvire() {
        return this.dataAbsolvire;
    }
    
    public void setDataAbsolvire(Date dataAbsolvire) {
        this.dataAbsolvire = dataAbsolvire;
    }




}


