

package com.adina.bean;

import com.adina.controller.ExtraInfoController;
import com.adina.util.FacesUtil;


public class ExtraInfoBean {
    private Long idAngajat;
    private String calificativ;
    private Integer an;

    public ExtraInfoBean(){
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

    public String getCalificativ() {
        return calificativ;
    }

    public void setCalificativ(String calificativ) {
        this.calificativ = calificativ;
    }

    public Integer getAn() {
        return an;
    }

    public void setAn(Integer an) {
        this.an = an;
    }

    

}
