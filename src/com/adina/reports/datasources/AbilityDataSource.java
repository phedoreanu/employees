/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adina.reports.datasources;

import com.adina.bean.AbilitateBean;
import com.adina.vo.AbilitateVO;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author fedo
 */
public class AbilityDataSource implements JRDataSource {

    private int index = -1;
    private String title;
    private AbilitateBean bean;
    private List<AbilitateVO> abilities;

    public AbilityDataSource() {
    }

    public AbilityDataSource(String title) {
        AbilitateBean bean = new AbilitateBean();
        abilities = bean.getAbilities();
    }

    @Override
    public boolean next() throws JRException {
        index++;
        return (index < abilities.size());
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        if ("abilitate_id_abilitate".equals(jrf.getName())) {
            return abilities.get(index).getId();
        } else if ("abilitate_nume_abilitate".equals(jrf.getName())) {
            return abilities.get(index).getName();
        } else {
            return null;
        }
    }
}
