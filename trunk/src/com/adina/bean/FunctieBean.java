package com.adina.bean;

import com.adina.controller.FunctieController;
import com.adina.util.FacesUtil;
import com.adina.vo.FunctieVO;
import java.io.Serializable;
import java.util.List;

public class FunctieBean implements Serializable {
    private Long id;
    private String name;
    private List<FunctieVO> positions;

   public FunctieBean(){
       try{
           String id1 = FacesUtil.getRequestParameter("id");
           setId(Long.parseLong(id1));
       }catch(NumberFormatException nfe){}
       FunctieController fctController = (FunctieController)FacesUtil.getBeanByName("functieController");
       fctController.fillPositionBean(this);
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FunctieVO> getPositions() {
        return positions;
    }

    public void setPositions(List<FunctieVO> positions) {
        this.positions = positions;
    }
}
