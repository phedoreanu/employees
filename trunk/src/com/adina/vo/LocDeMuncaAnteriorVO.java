package com.adina.vo;

import java.io.Serializable;

public class LocDeMuncaAnteriorVO implements Serializable {

    private Long idLocMunca;
    private String numeLoc;

    public Long getIdLocMunca() {
        return idLocMunca;
    }

    public void setIdLocMunca(Long idLocMunca) {
        this.idLocMunca = idLocMunca;
    }

    public String getNumeLoc() {
        return numeLoc;
    }

    public void setNumeLoc(String numeLoc) {
        this.numeLoc = numeLoc;
    }

    
}
