package com.adina.reports;

import com.adina.reports.util.ReportsUtil;
import com.adina.util.FacesUtil;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReportServlet extends HttpServlet {

    private final static Logger LOG = Logger.getLogger(ReportServlet.class);

    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException {
        doGet(httpServletRequest, httpServletResponse);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String reportName = request.getParameter("reportName");
        String title = request.getParameter("reportTitle");
        LOG.debug("ReportServlet: doGet: TITLE= " + title + " | REPORT NAME = " + reportName);

        if (reportName.equals(ReportsUtil.REPORT_ABILITY)) {
            ReportAbility.processFile(request, response);
//        } else if (reportName.equals(ReportsUtil.DEMANDE)) {
//            DemandeReport.processFile(request, response);
//        } else if (reportName.equals(ReportsUtil.DEVIS)) {
//            DevisReport.processFile(request, response);
//        }
        }
    }
}
