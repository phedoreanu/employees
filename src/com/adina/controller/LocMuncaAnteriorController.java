

package com.adina.controller;

import com.adina.DAO.LocMuncaAnteriorDAO;
import com.adina.bean.LocMuncaAnteriorBean;
import com.adina.util.FacesUtil;
import com.adina.vo.LocMuncaAnteriorVO;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.persistence.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.SystemException;


public class LocMuncaAnteriorController implements Serializable{
    //private static final Logger LOG = Logger.getLogger(LocMuncaAnteriorController.class);
    private LocMuncaAnteriorDAO workPlaceDAO;

    public LocMuncaAnteriorController(){
      workPlaceDAO = new LocMuncaAnteriorDAO();
    }

    public void fillPreviosWorkPlaceBean(LocMuncaAnteriorBean bean) throws SystemException {
        try {
            workPlaceDAO.fillPreviosWorkPlaceBean(bean);
        } catch (IllegalStateException ex) {
            Logger.getLogger(LocMuncaAnteriorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(LocMuncaAnteriorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.transaction.RollbackException ex) {
            Logger.getLogger(LocMuncaAnteriorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(LocMuncaAnteriorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(LocMuncaAnteriorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<LocMuncaAnteriorVO> getAllPreviousWorkPlaces()throws  IllegalStateException, SecurityException, RollbackException, HeuristicRollbackException, HeuristicMixedException, SystemException, javax.transaction.RollbackException {
        return workPlaceDAO.getAllPreviousWorkPlaces();
    }

    public String insertWorkPlace() throws IllegalStateException, SystemException, HeuristicRollbackException, javax.transaction.RollbackException, HeuristicMixedException{
        LocMuncaAnteriorBean bean = (LocMuncaAnteriorBean)FacesUtil.getBeanByName("locMuncaAnteriorBean");
        workPlaceDAO.insertWorkPlace(bean);
        return "workPlaceList";
    }

    public String updateWorkPlace() throws IllegalStateException, javax.transaction.RollbackException, SystemException, HeuristicRollbackException, HeuristicMixedException{
        LocMuncaAnteriorBean bean = (LocMuncaAnteriorBean)FacesUtil.getBeanByName("locMuncaAnteriorBean");
        workPlaceDAO.updateWorkPlace(bean);
        return "workPlaceList";
    }

     public String deleteWorkPlace() throws IllegalStateException, javax.transaction.RollbackException, SystemException, HeuristicRollbackException, HeuristicMixedException{
        LocMuncaAnteriorBean bean = (LocMuncaAnteriorBean)FacesUtil.getBeanByName("locMuncaAnteriorBean");
        workPlaceDAO.deleteWorkPlace(bean);
        return "workPlaceList";
    }
}
