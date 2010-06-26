package com.adina.controller;

import com.adina.DAO.ClasaSalariuDAO;
import com.adina.bean.ClasaSalariuBean;
import com.adina.util.FacesUtil;
import com.adina.vo.ClasaSalariuVO;
import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;

public class ClasaSalariuController implements Serializable {

    private static final Logger LOG = Logger.getLogger(ClasaSalariuController.class);
    private ClasaSalariuDAO clsSalariuDAO;

    public ClasaSalariuController() {
        clsSalariuDAO = new ClasaSalariuDAO();
    }

    public void fillClasaSalariuBean(ClasaSalariuBean bean) {
        clsSalariuDAO.fillClasaSalariuBean(bean);
    }

    public List<ClasaSalariuVO> getAllClasaSalariu() {
        return clsSalariuDAO.getAllClasaSalariu();
    }

    public String insertClasaSalariu() {
        ClasaSalariuBean bean = (ClasaSalariuBean) FacesUtil.getBeanByName("clasaSalariuBean");
        clsSalariuDAO.insertClasaSalariu(bean);
        return "afterSalaryOperations";
    }

    public String deleteClasaSalariu() {
        ClasaSalariuBean bean = (ClasaSalariuBean) FacesUtil.getBeanByName("clasaSalariuBean");
        String id1 = FacesUtil.getRequestParameter("idCls");
        Long idXX = Long.parseLong(id1);
        System.out.println("idXX= " + idXX);
        clsSalariuDAO.deleteClasaSalariu(idXX);
        return "afterSalaryOperations";
    }
}
