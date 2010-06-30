package com.adina.vo;

import com.adina.objects.ClasaConcediu;
import com.adina.objects.ClasaSalariu;
import com.adina.objects.Functie;
import com.adina.objects.Users;

public class EmployeeVO {

    private Long angajatId;
    private String name;
    private Functie functie;
    private ClasaConcediu clasaConcediu;
    private Users user;
    private ClasaSalariu clasaSalariu;
    private Long functieId;
    private String positionName;
    private Long clasaConcediuId;
    private Long userId;
    private Long clasaSalariuId;
    private String cnp;
    private String adresa;
    private byte activ;
    private Integer nrClasaConcediu;
    private Integer nrClasaSalariu;
    private String username;

    public EmployeeVO(Long idAngajat, ClasaConcediu clasaConcediu, Users user, ClasaSalariu clasaSalariu, Functie functie, String nume, String cnp, String adresa, byte activ) {
        this.activ = activ;
        this.adresa = adresa;
        this.angajatId = idAngajat;
        this.clasaConcediu = clasaConcediu;
        this.clasaSalariu = clasaSalariu;
        this.cnp = cnp;
        this.functie = functie;
        this.name = nume;
        this.user = user;
    }

    public EmployeeVO(Long idAngajat, Long clasaConcediuId, Long userId, Long clasaSalariuId, Long functieId, String nume, String cnp, String adresa, byte activ) {
        this.activ = activ;
        this.adresa = adresa;
        this.angajatId = idAngajat;
        this.clasaConcediuId = clasaConcediuId;
        this.clasaSalariuId = clasaSalariuId;
        this.cnp = cnp;
        this.functieId = functieId;
        this.name = nume;
        this.userId = userId;
    }

    public EmployeeVO(Long idAngajat, Integer nrClasaConcediu, String username, Integer nrClasaSalariu, String positionName, String nume, String cnp, String adresa, byte activ) {
        this.activ = activ;
        this.name = nume;
        this.adresa = adresa;
        this.username = username;
        this.angajatId = idAngajat;
        this.cnp = cnp;
        this.positionName = positionName;
        this.nrClasaConcediu = nrClasaConcediu;
        this.nrClasaSalariu = nrClasaSalariu;
    }

    public Long getAngajatId() {
        return angajatId;
    }

    public void setAngajatId(Long angajatId) {
        this.angajatId = angajatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Functie getFunctie() {
        return functie;
    }

    public void setFunctie(Functie functie) {
        this.functie = functie;
    }

    public ClasaConcediu getClasaConcediu() {
        return clasaConcediu;
    }

    public void setClasaConcediu(ClasaConcediu clasaConcediu) {
        this.clasaConcediu = clasaConcediu;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public ClasaSalariu getClasaSalariu() {
        return clasaSalariu;
    }

    public void setClasaSalariu(ClasaSalariu clasaSalariu) {
        this.clasaSalariu = clasaSalariu;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public byte getActiv() {
        return activ;
    }

    public void setActiv(byte activ) {
        this.activ = activ;
    }

    public Long getClasaConcediuId() {
        return clasaConcediuId;
    }

    public void setClasaConcediuId(Long clasaConcediuId) {
        this.clasaConcediuId = clasaConcediuId;
    }

    public Long getClasaSalariuId() {
        return clasaSalariuId;
    }

    public void setClasaSalariuId(Long clasaSalariuId) {
        this.clasaSalariuId = clasaSalariuId;
    }

    public Long getFunctieId() {
        return functieId;
    }

    public void setFunctieId(Long functieId) {
        this.functieId = functieId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getNrClasaConcediu() {
        return nrClasaConcediu;
    }

    public void setNrClasaConcediu(Integer nrClasaConcediu) {
        this.nrClasaConcediu = nrClasaConcediu;
    }

    public Integer getNrClasaSalariu() {
        return nrClasaSalariu;
    }

    public void setNrClasaSalariu(Integer nrClasaSalariu) {
        this.nrClasaSalariu = nrClasaSalariu;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
