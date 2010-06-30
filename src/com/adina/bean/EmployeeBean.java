package com.adina.bean;

import com.adina.controller.EmployeeController;
import com.adina.util.FacesUtil;
import com.adina.vo.EmployeeVO;
import java.util.List;
import javax.faces.model.SelectItem;

public class EmployeeBean {

    private Long angajatId;
    private String name;
    private Long positionId;
    private String positionName;
    private Long clasaConcediuId;
    private Long userId;
    private Long clasaSalariuId;
    private String cnp;
    private String adresa;
    private byte activ;
    private List<EmployeeVO> employeesList;
    private List<SelectItem> positions;
    private List<SelectItem> users;
    private List<SelectItem> holidayClass;
    private List<SelectItem> salaryClass;

    public EmployeeBean() {
        try {
            String id1 = FacesUtil.getRequestParameter("id");
            setAngajatId(Long.parseLong(id1));
        } catch (NumberFormatException nfe) {
        }

        EmployeeController employeeController = (EmployeeController) FacesUtil.getBeanByName("employeeController");
        employeeController.fillEmployeeBean(this);
    }

    public Long getAngajatId() {
        return angajatId;
    }

    public void setAngajatId(Long angajatId) {
        this.angajatId = angajatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClasaConcediuId() {
        return clasaConcediuId;
    }

    public void setClasaConcediuId(Long clasaConcediuId) {
        this.clasaConcediuId = clasaConcediuId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getClasaSalariuId() {
        return clasaSalariuId;
    }

    public void setClasaSalariuId(Long clasaSalariuId) {
        this.clasaSalariuId = clasaSalariuId;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public byte getActiv() {
        return activ;
    }

    public void setActiv(byte activ) {
        this.activ = activ;
    }

    public List<EmployeeVO> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<EmployeeVO> employeesList) {
        this.employeesList = employeesList;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public List<SelectItem> getPositions() {
        return positions;
    }

    public void setPositions(List<SelectItem> positions) {
        this.positions = positions;
    }

    public List<SelectItem> getUsers() {
        return users;
    }

    public void setUsers(List<SelectItem> users) {
        this.users = users;
    }

    public List<SelectItem> getHolidayClass() {
        return holidayClass;
    }

    public void setHolidayClass(List<SelectItem> holidayClass) {
        this.holidayClass = holidayClass;
    }

    public List<SelectItem> getSalaryClass() {
        return salaryClass;
    }

    public void setSalaryClass(List<SelectItem> salaryClass) {
        this.salaryClass = salaryClass;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
