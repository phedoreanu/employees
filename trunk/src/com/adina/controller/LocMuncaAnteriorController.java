package com.adina.controller;

import com.adina.DAO.LocMuncaAnteriorDAO;
import com.adina.bean.LocMuncaAnteriorBean;
import com.adina.util.FacesUtil;
import com.adina.vo.LocMuncaAnteriorVO;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.SystemException;
import org.apache.log4j.Logger;

public class LocMuncaAnteriorController implements Serializable {

    private static final Logger LOG = Logger.getLogger(LocMuncaAnteriorController.class);
    private LocMuncaAnteriorDAO workPlaceDAO;

    public LocMuncaAnteriorController() {
        workPlaceDAO = new LocMuncaAnteriorDAO();
    }

    public void fillPreviosWorkPlaceBean(LocMuncaAnteriorBean bean) throws SystemException {
        try {
            workPlaceDAO.fillPreviosWorkPlaceBean(bean);
        } catch (Exception ex) {
            LOG.error("", ex);
        }
    }

    public List<LocMuncaAnteriorVO> getAllPreviousWorkPlaces() throws IllegalStateException, SecurityException, RollbackException, HeuristicRollbackException, HeuristicMixedException, SystemException, javax.transaction.RollbackException {
        return workPlaceDAO.getAllPreviousWorkPlaces();
    }

    public String insertWorkPlace() throws IllegalStateException, SystemException, HeuristicRollbackException, javax.transaction.RollbackException, HeuristicMixedException {
        LocMuncaAnteriorBean bean = (LocMuncaAnteriorBean) FacesUtil.getBeanByName("locMuncaAnteriorBean");
        workPlaceDAO.insertWorkPlace(bean);
        return "workPlaceList";
    }

    public String updateWorkPlace() throws IllegalStateException, javax.transaction.RollbackException, SystemException, HeuristicRollbackException, HeuristicMixedException {
        LocMuncaAnteriorBean bean = (LocMuncaAnteriorBean) FacesUtil.getBeanByName("locMuncaAnteriorBean");
        workPlaceDAO.updateWorkPlace(bean);
        return "workPlaceList";
    }

    public String deleteWorkPlace() throws IllegalStateException, javax.transaction.RollbackException, SystemException, HeuristicRollbackException, HeuristicMixedException {
        LocMuncaAnteriorBean bean = (LocMuncaAnteriorBean) FacesUtil.getBeanByName("locMuncaAnteriorBean");
        workPlaceDAO.deleteWorkPlace(bean);
        return "workPlaceList";
    }
}
