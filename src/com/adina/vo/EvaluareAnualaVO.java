package com.adina.vo;

import java.io.Serializable;

public class EvaluareAnualaVO implements Serializable {

    private Long idAngajat;
    private Long idEvaluare;
    private String calificativ;
    private Integer an;

    public Integer getAn() {
        return an;
    }

    public void setAn(Integer an) {
        this.an = an;
    }

    public String getCalificativ() {
        return calificativ;
    }

    public void setCalificativ(String calificativ) {
        this.calificativ = calificativ;
    }

    public Long getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(Long idAngajat) {
        this.idAngajat = idAngajat;
    }

    public Long getIdEvaluare() {
        return idEvaluare;
    }

    public void setIdEvaluare(Long idEvaluare) {
        this.idEvaluare = idEvaluare;
    }
}