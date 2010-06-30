package com.adina.bean;

import com.adina.controller.ExtraInfoController;
import com.adina.util.FacesUtil;
import com.adina.vo.AngajatAbilitateVO;
import com.adina.vo.AngajatLocAnteriorVO;
import com.adina.vo.EvaluareAnualaVO;
import com.adina.vo.StudiiAngajatVO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExtraInfoBean implements Serializable {

    private Long idAngajat;

    /* evaluare anuala */
    List<EvaluareAnualaVO> evaluariAnuale;

    /* studii angajat */
    List<StudiiAngajatVO> studiiAnagajat;

    /* loc de munca anterior */
    List<AngajatLocAnteriorVO> locuriAnterioare;

    /* angajat abilitate */
    List<AngajatAbilitateVO> abilitati;

    public ExtraInfoBean() {
        try {
            String id1 = FacesUtil.getRequestParameter("id");
            setIdAngajat(Long.parseLong(id1));
        } catch (NumberFormatException nfe) {
        }

        ExtraInfoController extraInfoController = (ExtraInfoController) FacesUtil.getBeanByName("extraInfoController");
        extraInfoController.fillExtraInfoBean(this);
    }

    public Long getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(Long idAngajat) {
        this.idAngajat = idAngajat;
    }

    public List<AngajatAbilitateVO> getAbilitati() {
        return abilitati;
    }

    public void setAbilitati(List<AngajatAbilitateVO> abilitati) {
        this.abilitati = abilitati;
    }

    public List<EvaluareAnualaVO> getEvaluariAnuale() {
        if (evaluariAnuale == null) {
            evaluariAnuale = new ArrayList<EvaluareAnualaVO>();
        }
        return evaluariAnuale;
    }

    public void setEvaluariAnuale(List<EvaluareAnualaVO> evaluariAnuale) {
        this.evaluariAnuale = evaluariAnuale;
    }

    public List<AngajatLocAnteriorVO> getLocuriAnterioare() {
        if (locuriAnterioare == null) {
            locuriAnterioare = new ArrayList<AngajatLocAnteriorVO>();
        }
        return locuriAnterioare;
    }

    public void setLocuriAnterioare(List<AngajatLocAnteriorVO> locuriAnterioare) {
        this.locuriAnterioare = locuriAnterioare;
    }

    public List<StudiiAngajatVO> getStudiiAnagajat() {
        if (studiiAnagajat == null) {
            studiiAnagajat = new ArrayList<StudiiAngajatVO>();
        }
        return studiiAnagajat;
    }

    public void setStudiiAnagajat(List<StudiiAngajatVO> studiiAnagajat) {
        this.studiiAnagajat = studiiAnagajat;
    }
}
