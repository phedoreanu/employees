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

    public String updateAbilitate() {
        AbilitateBean abilitateBean = (AbilitateBean) FacesUtil.getBeanByName("abilitateBean");

        abilitateDAO.updateAbilitate(abilitateBean);

        return "adminList";
    }

    public List<AbilitateVO> getAllAbilities() {
       return abilitateDAO.getAllAbilities();
    }

    public void fillAbilityBean(AbilitateBean bean) {
        abilitateDAO.fillAbilityBean(bean);
    }
    
//    public String insertAbilitate() {
//        abilitateDAO.insertAbilitate(numeAbilitate);
//        numeAbilitate = "";
//        return null;
//    }
//
//    public String deleteAbilitate() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        Map<String, String> params = context.getExternalContext().getRequestParameterMap();
//        Long idAbil = Long.parseLong(params.get("idAbil"));
//        AbilitateDAO abilitateDAO = new AbilitateDAO();
//        abilitateDAO.deleteAbilitate(idAbil);
//        return null;
//    }
}
