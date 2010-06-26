package com.adina.vo;

public class ClasaSalariuVO {

    private Long id;
    private int nrClasa;

    public ClasaSalariuVO(Long id, int nrClasa) {
        this.id = id;
        this.nrClasa = nrClasa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNrClasa() {
        return nrClasa;
    }

    public void setNrClasa(int nrClasa) {
        this.nrClasa = nrClasa;
    }
}
