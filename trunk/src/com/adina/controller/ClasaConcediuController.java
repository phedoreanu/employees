package com.adina.controller;

import com.adina.DAO.ClasaConcediuDAO;
import com.adina.bean.ClasaConcediuBean;
import com.adina.util.FacesUtil;
import com.adina.vo.ClasaConcediuVO;
import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;

public class ClasaConcediuController implements Serializable {

    private static final Logger LOG = Logger.getLogger(AbilitateController.class);
    private ClasaConcediuDAO clasaConcediuDAO;

    public ClasaConcediuController() {
        clasaConcediuDAO = new ClasaConcediuDAO();
    }

    public void fillClasaConcediuBean(ClasaConcediuBean bean) {
        clasaConcediuDAO.fillClasaConcediuBean(bean);
    }

    public List<ClasaConcediuVO> gettAllClasaConcediu() {
        return clasaConcediuDAO.getAllClasaConcediu();
    }

    public String insertClasaConcediu() {
        ClasaConcediuBean bean = (ClasaConcediuBean) FacesUtil.getBeanByName("clasaConcediuBean");
        clasaConcediuDAO.insertClasaConcediu(bean);
        return "afterHolidayOperation";
    }

    public String deleteClasaConcediu(){
        String id1 = FacesUtil.getRequestParameter("idCls");
        Long idXX = Long.parseLong(id1);
        System.out.println("idClasaConcediu= " + idXX);
        clasaConcediuDAO.deleteClasaConcediu(idXX);
        return "afterHolidayOperation";
    }

}
