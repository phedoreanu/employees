package com.adina.objects;

public class AngajatAbilitate  implements java.io.Serializable {


     private Long idAngajatAbilitate;
     private Angajat angajat;
     private Abilitate abilitate;
     private Integer nota;

    public AngajatAbilitate() {
    }

    public AngajatAbilitate(Angajat angajat, Abilitate abilitate, Integer nota) {
       this.angajat = angajat;
       this.abilitate = abilitate;
       this.nota = nota;
    }
   
    public Long getIdAngajatAbilitate() {
        return this.idAngajatAbilitate;
    }
    
    public void setIdAngajatAbilitate(Long idAngajatAbilitate) {
        this.idAngajatAbilitate = idAngajatAbilitate;
    }
    public Angajat getAngajat() {
        return this.angajat;
    }
    
    public void setAngajat(Angajat angajat) {
        this.angajat = angajat;
    }
    public Abilitate getAbilitate() {
        return this.abilitate;
    }
    
    public void setAbilitate(Abilitate abilitate) {
        this.abilitate = abilitate;
    }
    public Integer getNota() {
        return this.nota;
    }
    
    public void setNota(Integer nota) {
        this.nota = nota;
    }




}


