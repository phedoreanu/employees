package com.adina.bean;

import com.adina.controller.AbilitateController;
import com.adina.util.FacesUtil;
import com.adina.vo.AbilitateVO;
import java.io.Serializable;
import java.util.List;

public class AbilitateBean implements Serializable {

    private Long id;
    private String name;
    private List<AbilitateVO> abilities;

    public AbilitateBean() {

        try {
            String id = FacesUtil.getRequestParameter("id");
            setId(Long.parseLong(id));
        } catch (NumberFormatException nfe) {
            //nfe.printStackTrace();
        }

        AbilitateController abilitateController = (AbilitateController) FacesUtil.getBeanByName("abilitateController");

        abilitateController.fillAbilityBean(this);
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

    public List<AbilitateVO> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilitateVO> abilities) {
        this.abilities = abilities;
    }
}
