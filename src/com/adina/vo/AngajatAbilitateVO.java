package com.adina.vo;

import java.io.Serializable;
import java.util.List;

public class AngajatAbilitateVO implements Serializable { 

    private int nota;
    private Long idAngajat;
    private Long idAngajatAbilitate;
    List<AbilitateVO> abilitati;

    public List<AbilitateVO> getAbilitati() {
        return abilitati;
    }

    public void setAbilitati(List<AbilitateVO> abilitati) {
        this.abilitati = abilitati;
    }

    public Long getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(Long idAngajat) {
        this.idAngajat = idAngajat;
    }

    public Long getIdAngajatAbilitate() {
        return idAngajatAbilitate;
    }

    public void setIdAngajatAbilitate(Long idAngajatAbilitate) {
        this.idAngajatAbilitate = idAngajatAbilitate;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }


}
