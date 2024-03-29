package com.adina.objects;

import java.util.HashSet;
import java.util.Set;


public class Angajat  implements java.io.Serializable {


     private Long idAngajat;
     private ClasaConcediu clasaConcediu;
     private Users users;
     private ClasaSalariu clasaSalariu;
     private Functie functie;
     private String nume;
     private String cnp;
     private String adresa;
     private byte activ;
     private Set angajatAbilitates = new HashSet(0);
     private Set studiiAngajats = new HashSet(0);
     private Set angajatLocAnteriors = new HashSet(0);
     private Set angajatZiMuncas = new HashSet(0);
     private Set evaluareAnualas = new HashSet(0);

    public Angajat() {
    }

	
    public Angajat(String nume, String cnp, String adresa, byte activ) {
        this.nume = nume;
        this.cnp = cnp;
        this.adresa = adresa;
        this.activ = activ;
    }
    public Angajat(ClasaConcediu clasaConcediu, Users users, ClasaSalariu clasaSalariu, Functie functie, String nume, String cnp, String adresa, byte activ, Set angajatAbilitates, Set studiiAngajats, Set angajatLocAnteriors, Set angajatZiMuncas, Set evaluareAnualas) {
       this.clasaConcediu = clasaConcediu;
       this.users = users;
       this.clasaSalariu = clasaSalariu;
       this.functie = functie;
       this.nume = nume;
       this.cnp = cnp;
       this.adresa = adresa;
       this.activ = activ;
       this.angajatAbilitates = angajatAbilitates;
       this.studiiAngajats = studiiAngajats;
       this.angajatLocAnteriors = angajatLocAnteriors;
       this.angajatZiMuncas = angajatZiMuncas;
       this.evaluareAnualas = evaluareAnualas;
    }
   
    public Long getIdAngajat() {
        return this.idAngajat;
    }
    
    public void setIdAngajat(Long idAngajat) {
        this.idAngajat = idAngajat;
    }
    public ClasaConcediu getClasaConcediu() {
        return this.clasaConcediu;
    }
    
    public void setClasaConcediu(ClasaConcediu clasaConcediu) {
        this.clasaConcediu = clasaConcediu;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public ClasaSalariu getClasaSalariu() {
        return this.clasaSalariu;
    }
    
    public void setClasaSalariu(ClasaSalariu clasaSalariu) {
        this.clasaSalariu = clasaSalariu;
    }
    public Functie getFunctie() {
        return this.functie;
    }
    
    public void setFunctie(Functie functie) {
        this.functie = functie;
    }
    public String getNume() {
        return this.nume;
    }
    
    public void setNume(String nume) {
        this.nume = nume;
    }
    public String getCnp() {
        return this.cnp;
    }
    
    public void setCnp(String cnp) {
        this.cnp = cnp;
    }
    public String getAdresa() {
        return this.adresa;
    }
    
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    public byte getActiv() {
        return this.activ;
    }
    
    public void setActiv(byte activ) {
        this.activ = activ;
    }
    public Set getAngajatAbilitates() {
        return this.angajatAbilitates;
    }
    
    public void setAngajatAbilitates(Set angajatAbilitates) {
        this.angajatAbilitates = angajatAbilitates;
    }
    public Set getStudiiAngajats() {
        return this.studiiAngajats;
    }
    
    public void setStudiiAngajats(Set studiiAngajats) {
        this.studiiAngajats = studiiAngajats;
    }
    public Set getAngajatLocAnteriors() {
        return this.angajatLocAnteriors;
    }
    
    public void setAngajatLocAnteriors(Set angajatLocAnteriors) {
        this.angajatLocAnteriors = angajatLocAnteriors;
    }
    public Set getAngajatZiMuncas() {
        return this.angajatZiMuncas;
    }
    
    public void setAngajatZiMuncas(Set angajatZiMuncas) {
        this.angajatZiMuncas = angajatZiMuncas;
    }
    public Set getEvaluareAnualas() {
        return this.evaluareAnualas;
    }
    
    public void setEvaluareAnualas(Set evaluareAnualas) {
        this.evaluareAnualas = evaluareAnualas;
    }




}


