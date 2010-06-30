package com.adina.controller;

import com.adina.DAO.ExtraInfoDAO;
import com.adina.bean.ExtraInfoBean;
import java.io.Serializable;

public class ExtraInfoController implements Serializable {

    private ExtraInfoDAO extraInfoDAO;

    public ExtraInfoController() {
        extraInfoDAO = new ExtraInfoDAO();
    }

    public void fillExtraInfoBean(ExtraInfoBean bean) {
        extraInfoDAO.fillExtraInfoBean(bean);
    }
}
