package com.adina.bean;

import com.adina.controller.EmployeeController;
import com.adina.util.FacesUtil;
import com.adina.vo.EmployeeVO;
import java.util.List;

public class EmployeeBean {

    private Long angajatId;
    private String name;
    private Long functieId;
    private Long clasaConcediuId;
    private Long userId;
    private Long clasaSalariuId;
    private String cnp;
    private String adresa;
    private byte activ;
    private List<EmployeeVO> employeesList;

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

    public Long getFunctieId() {
        return functieId;
    }

    public void setFunctieId(Long functieId) {
        this.functieId = functieId;
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
}
