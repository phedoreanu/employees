package com.adina.objects;


public class EvaluareAnuala  implements java.io.Serializable {


     private Long idEvaluare;
     private Angajat angajat;
     private String calificativ;
     private Integer an;

    public EvaluareAnuala() {
    }

    public EvaluareAnuala(Angajat angajat, String calificativ, Integer an) {
       this.angajat = angajat;
       this.calificativ = calificativ;
       this.an = an;
    }
   
    public Long getIdEvaluare() {
        return this.idEvaluare;
    }
    
    public void setIdEvaluare(Long idEvaluare) {
        this.idEvaluare = idEvaluare;
    }
    public Angajat getAngajat() {
        return this.angajat;
    }
    
    public void setAngajat(Angajat angajat) {
        this.angajat = angajat;
    }
    public String getCalificativ() {
        return this.calificativ;
    }
    
    public void setCalificativ(String calificativ) {
        this.calificativ = calificativ;
    }
    public Integer getAn() {
        return this.an;
    }
    
    public void setAn(Integer an) {
        this.an = an;
    }




}


