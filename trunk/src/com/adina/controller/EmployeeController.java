package com.adina.controller;

import com.adina.DAO.EmployeeDAO;
import com.adina.bean.EmployeeBean;
import com.adina.util.FacesUtil;
import org.apache.log4j.Logger;

public class EmployeeController {

    private static final Logger LOG = Logger.getLogger(EmployeeController.class);
    private EmployeeDAO employeeDAO;

    public EmployeeController() {
        employeeDAO = new EmployeeDAO();
    }

    public void fillEmployeeBean(EmployeeBean bean) {
        employeeDAO.fillEmployeeBean(bean);
    }

    public String insertEmployee() {
        EmployeeBean bean = (EmployeeBean) FacesUtil.getBeanByName("employeeBean");
        employeeDAO.insertEmployee(bean);
        return "afterEmployeeOperations";
    }

    public String updateEmployee() {
        EmployeeBean bean = (EmployeeBean) FacesUtil.getBeanByName("employeeBean");
        employeeDAO.updateEmployee(bean);
        return "afterEmployeeOperations";
    }

    public String disableEmployee() {
        EmployeeBean bean = (EmployeeBean) FacesUtil.getBeanByName("employeeBean");
        employeeDAO.disableEmployee(bean);
        return "afterEmployeeOperations";
    }

    public String addExtraInfo() {
        EmployeeBean bean = (EmployeeBean) FacesUtil.getBeanByName("employeeBean");
        employeeDAO.addExtraInfo(bean);
        return "afterEmployeeOperations";
    }
}
