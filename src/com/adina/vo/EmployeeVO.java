package com.adina.vo;

public class EmployeeVO {

    private Long idAngajat;
    private String name;
    private FunctieVO functie;
    private ClasaConcediuVO clasaConcediu;
    private UserVO user;
    private ClasaSalariuVO clasaSalariu;
    private String cnp;
    private String adresa;
    private byte activ;

    public EmployeeVO(Long idAngajat, ClasaConcediuVO clasaConcediu, UserVO user, ClasaSalariuVO clasaSalariu, FunctieVO functie, String nume, String cnp, String adresa, byte activ) {
        this.activ = activ;
        this.adresa = adresa;
        this.idAngajat = idAngajat;
        this.clasaConcediu = clasaConcediu;
        this.clasaSalariu = clasaSalariu;
        this.cnp = cnp;
        this.functie = functie;
        this.name = nume;
        this.user = user;
    }

    public Long getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(Long idAngajat) {
        this.idAngajat = idAngajat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FunctieVO getFunctie() {
        return functie;
    }

    public void setFunctie(FunctieVO functie) {
        this.functie = functie;
    }

    public ClasaConcediuVO getClasaConcediu() {
        return clasaConcediu;
    }

    public void setClasaConcediu(ClasaConcediuVO clasaConcediu) {
        this.clasaConcediu = clasaConcediu;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public ClasaSalariuVO getClasaSalariu() {
        return clasaSalariu;
    }

    public void setClasaSalariu(ClasaSalariuVO clasaSalariu) {
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

   
}
