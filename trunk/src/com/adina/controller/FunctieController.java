package com.adina.controller;

import com.adina.DAO.FunctieDAO;
import com.adina.bean.FunctieBean;
import com.adina.util.FacesUtil;
import com.adina.vo.FunctieVO;
import java.io.Serializable;
import java.util.List;

public class FunctieController implements Serializable {

    private FunctieDAO fctDAO;

    public FunctieController() {
        fctDAO = new FunctieDAO();
    }

    public void fillPositionBean(FunctieBean bean) {
        fctDAO.fillPositionBean(bean);
    }

    public List<FunctieVO> getAllPositions() {
        return fctDAO.getAllFunctie();
    }

    public String insertFunctie() {
        FunctieBean bean = (FunctieBean) FacesUtil.getBeanByName("functieBean");
        fctDAO.insertFunctie(bean);
        return "afterPositionOperations";
    }

    public String updateFunctie() {
        FunctieBean bean = (FunctieBean) FacesUtil.getBeanByName("functieBean");
        fctDAO.updateFunctie(bean);
        return "afterPositionOperations";
    }

    public String deleteFunctie() {
        FunctieBean bean = (FunctieBean) FacesUtil.getBeanByName("functieBean");
        fctDAO.deleteFunctie(bean);
        return "afterPositionOperations";
    }
}
