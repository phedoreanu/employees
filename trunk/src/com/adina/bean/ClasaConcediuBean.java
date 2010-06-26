package com.adina.bean;

import com.adina.controller.ClasaConcediuController;
import com.adina.util.FacesUtil;
import com.adina.vo.ClasaConcediuVO;
import java.io.Serializable;
import java.util.List;

public class ClasaConcediuBean implements Serializable {

    private Long id;
    private int nrClasa;
    private List<ClasaConcediuVO> clasaConcediuList;

    public ClasaConcediuBean() {
        try {
        String id1 = FacesUtil.getRequestParameter("idCls");
        setId(Long.parseLong(id1));
        } catch (NumberFormatException nfe) {
        }
  
        ClasaConcediuController clasaConcediuController = (ClasaConcediuController) FacesUtil.getBeanByName("clasaConcediuController");
        clasaConcediuController.fillClasaConcediuBean(this);
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

    public List<ClasaConcediuVO> getClasaConcediuList() {
        return clasaConcediuList;
    }

    public void setClasaConcediuList(List<ClasaConcediuVO> allClasaConcediu) {
        this.clasaConcediuList = allClasaConcediu;
    }
}
