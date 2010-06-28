package com.adina.controller;

import com.adina.DAO.AbilitateDAO;
import com.adina.bean.AbilitateBean;
import com.adina.util.FacesUtil;
import com.adina.vo.AbilitateVO;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

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
        return "afterInsert";
    }

    public String insertAbilitate() {
        AbilitateBean abilitateBean = (AbilitateBean) FacesUtil.getBeanByName("abilitateBean");
        abilitateDAO.insertAbilitate(abilitateBean);
        return "afterInsert";
    }

    public void validateAbilityDuplicates(FacesContext context, UIComponent toValidate, Object value) {
        String message = "";
        String abilityName = (String) value;
        List<AbilitateVO> abilityList = getAllAbilities();
        for (AbilitateVO al : abilityList) {
            if (al.getName().equals(abilityName)) {
                message = "Name duplicate! Please insert a different name!";
                context.addMessage(toValidate.getClientId(context), new FacesMessage(message));
                break;
            }
        }
    }
}
