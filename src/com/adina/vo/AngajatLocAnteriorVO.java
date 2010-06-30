package com.adina.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AngajatLocAnteriorVO implements Serializable {

    private Long idAngajat;
    private Long idAngajatLoc;
    private Long idLocMunca;
    private String numeLoc;
    private Date dataAngajare;
    private Date dataPlecare;
    private List<LocDeMuncaAnteriorVO> locuriDeMuncaAnterior;

    public Date getDataAngajare() {
        return dataAngajare;
    }

    public void setDataAngajare(Date dataAngajare) {
        this.dataAngajare = dataAngajare;
    }

    public Date getDataPlecare() {
        return dataPlecare;
    }

    public void setDataPlecare(Date dataPlecare) {
        this.dataPlecare = dataPlecare;
    }

    public Long getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(Long idAngajat) {
        this.idAngajat = idAngajat;
    }

    public Long getIdAngajatLoc() {
        return idAngajatLoc;
    }

    public void setIdAngajatLoc(Long idAngajatLoc) {
        this.idAngajatLoc = idAngajatLoc;
    }

    public Long getIdLocMunca() {
        return idLocMunca;
    }

    public void setIdLocMunca(Long idLocMunca) {
        this.idLocMunca = idLocMunca;
    }

    public List<LocDeMuncaAnteriorVO> getLocuriDeMuncaAnterior() {
        if(locuriDeMuncaAnterior == null) locuriDeMuncaAnterior = new ArrayList<LocDeMuncaAnteriorVO>();
        return locuriDeMuncaAnterior;
    }

    public void setLocuriDeMuncaAnterior(List<LocDeMuncaAnteriorVO> locuriDeMuncaAnterior) {
        this.locuriDeMuncaAnterior = locuriDeMuncaAnterior;
    }

    public String getNumeLoc() {
        return numeLoc;
    }

    public void setNumeLoc(String numeLoc) {
        this.numeLoc = numeLoc;
    }

    
}
