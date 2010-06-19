package com.adina.controller;

import com.adina.DAO.AbilitateDAO;
import com.adina.bean.AbilitateBean;
import com.adina.util.FacesUtil;
import com.adina.vo.AbilitateVO;
import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

public class AbilitateController implements Serializable {

    private static final Logger LOG = Logger.getLogger(AbilitateController.class);
    private AbilitateDAO abilitateDAO;

    public AbilitateController() {
        abilitateDAO = new AbilitateDAO();
    }

    public void fillAbilityBean(AbilitateBean bean) {
        abilitateDAO.fillAbilityBean(bean);
    }

    public List<AbilitateVO> getAllAbilities() {
        return abilitateDAO.getAllAbilities();
    }

    public String updateAbilitate() {
        AbilitateBean abilitateBean = (AbilitateBean) FacesUtil.getBeanByName("abilitateBean");
        abilitateDAO.updateAbilitate(abilitateBean);
        return "afterInsert";
    }

    public String deleteAbilitate() {
        AbilitateBean abilitateBean = (AbilitateBean) FacesUtil.getBeanByName("abilitateBean");
        abilitateDAO.deleteAbilitate(abilitateBean);
        return "adminList";
    }

    public String insertAbilitate() {
        AbilitateBean abilitateBean = (AbilitateBean) FacesUtil.getBeanByName("abilitateBean");
        abilitateDAO.insertAbilitate(abilitateBean);
        return "afterInsert";
    }
}
