package com.adina.bean;

import com.adina.controller.ClasaSalariuController;
import com.adina.util.FacesUtil;
import com.adina.vo.ClasaSalariuVO;
import java.io.Serializable;
import java.util.List;

public class ClasaSalariuBean implements Serializable {

    private Long id;
    private int nrClasa;
    private List<ClasaSalariuVO> clsSalariuList;

    public ClasaSalariuBean() {
        try {
            String id1 = FacesUtil.getRequestParameter("idCls");
            setId(Long.parseLong(id1));
        } catch (NumberFormatException nfe) {
        }
        ClasaSalariuController clsSalariuController = (ClasaSalariuController) FacesUtil.getBeanByName("clasaSalariuController");
        clsSalariuController.fillClasaSalariuBean(this);
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

    public List<ClasaSalariuVO> getClsSalariuList() {
        return clsSalariuList;
    }

    public void setClsSalariuList(List<ClasaSalariuVO> clsSalariuList) {
        this.clsSalariuList = clsSalariuList;
    }
}
