/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adina.util;

import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.el.VariableResolver;
import org.apache.log4j.Logger;

/**
 *
 * @author fedo
 */
public class FacesUtil {

    private static final Logger LOG = Logger.getLogger(FacesUtil.class);

    public static Object getBeanByName(String name) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext == null) {
            LOG.warn("No faces context, cannot getBeanByName", new Throwable());
            return null;
        }

        VariableResolver variableResolver = facesContext.getApplication().getVariableResolver();
        Object bean = variableResolver.resolveVariable(facesContext, name);
        if (bean == null) {
            LOG.error("No bean by the name [" + name + "] can be found in the faces context.", new Throwable());
        }
        return bean;
    }

    public static String getRequestParameter(String key) {
        Map map = getRequestParameters();
        if (map == null) {
            return null;
        }
        return (String) map.get(key);
    }

    public static Map getRequestParameters() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext == null) {
            return new HashMap();
        }
        return facesContext.getExternalContext().getRequestParameterMap();
    }
}
