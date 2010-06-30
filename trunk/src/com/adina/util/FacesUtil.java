package com.adina.util;

import java.util.HashMap;
import java.util.Map;
import javax.faces.FactoryFinder;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.el.VariableResolver;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

public class FacesUtil {

    private static final Logger LOG = Logger.getLogger(FacesUtil.class);

    public static Object getBeanByName(String name) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext == null) {
            LOG.warn("No faces context, cannot getBeanByName", new Throwable());
            System.out.println("No faces context, cannot getBeanByName");
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

    public static FacesContext getFacesContext(ServletRequest request, ServletResponse response) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext != null) {
            return facesContext;
        }

        FacesContextFactory contextFactory = (FacesContextFactory) FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
        LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
        Lifecycle lifecycle = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);

        // Either set a private member servletContext = filterConfig.getServletContext();
        // in you filter init() method or set it here like this:
        ServletContext servletContext = ((HttpServletRequest) request).getSession().getServletContext();
        // Note that the above line would fail if you are using any other protocol than http

        // Doesn't set this instance as the current instance of FacesContext.getCurrentInstance
        facesContext = contextFactory.getFacesContext(servletContext, request, response, lifecycle);

        // set a new viewRoot, otherwise context.getViewRoot returns null
        UIViewRoot view = facesContext.getApplication().getViewHandler().createView(facesContext, "yourOwnID");
        facesContext.setViewRoot(view);

        return facesContext;
    }
}
