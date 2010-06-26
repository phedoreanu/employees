
package com.adina.bean;

import com.adina.controller.LocMuncaAnteriorController;
import com.adina.util.FacesUtil;
import com.adina.vo.LocMuncaAnteriorVO;
import java.io.Serializable;
import java.util.List;
import javax.transaction.SystemException;

public class LocMuncaAnteriorBean implements Serializable{
    private Long id;
    private String name;
    private List<LocMuncaAnteriorVO> workPlaceList;

    public LocMuncaAnteriorBean() throws SystemException{
        try {
            String id1 = FacesUtil.getRequestParameter("id");
            setId(Long.parseLong(id1));
        } catch (NumberFormatException nfe) {
        }

        LocMuncaAnteriorController locMuncaAnteriorController = (LocMuncaAnteriorController) FacesUtil.getBeanByName("locMuncaAnteriorController");

        locMuncaAnteriorController.fillPreviosWorkPlaceBean(this);
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

  
    public List<LocMuncaAnteriorVO> getWorkPlaceList() {
        return workPlaceList;
    }

  
    public void setWorkPlaceList(List<LocMuncaAnteriorVO> workPlaceList) {
        this.workPlaceList = workPlaceList;
    }

    
}
