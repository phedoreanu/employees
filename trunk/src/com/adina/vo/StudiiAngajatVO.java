package com.adina.vo;

import java.io.Serializable;
import java.util.Date;

public class StudiiAngajatVO implements Serializable {

    private Long idAngajat;
    private Long idStudiiAngajat;
    private String numeInstitut;
    private String tipStudiu;
    private Date dateAbsolvire;

    public Long getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(Long idAngajat) {
        this.idAngajat = idAngajat;
    }

    public Date getDateAbsolvire() {
        return dateAbsolvire;
    }

    public void setDateAbsolvire(Date dateAbsolvire) {
        this.dateAbsolvire = dateAbsolvire;
    }

    public Long getIdStudiiAngajat() {
        return idStudiiAngajat;
    }

    public void setIdStudiiAngajat(Long idStudiiAngajat) {
        this.idStudiiAngajat = idStudiiAngajat;
    }

    public String getNumeInstitut() {
        return numeInstitut;
    }

    public void setNumeInstitut(String numeInstitut) {
        this.numeInstitut = numeInstitut;
    }

    public String getTipStudiu() {
        return tipStudiu;
    }

    public void setTipStudiu(String tipStudiu) {
        this.tipStudiu = tipStudiu;
    }

    
}