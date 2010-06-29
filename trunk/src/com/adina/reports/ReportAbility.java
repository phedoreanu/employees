package com.adina.reports;

import com.adina.reports.datasources.AbilityDataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import org.apache.log4j.Logger;

public class ReportAbility {

    private static final Logger LOG = Logger.getLogger(ReportAbility.class);

    public static byte[] pdfArray(String title) {
        JasperPrint jasperPrint;
        byte[] pdfByteArray = null;

        AbilityDataSource abilityDataSource = new AbilityDataSource(title);
        Reports report = new Reports();
        try {
            jasperPrint = report.generateReport("/reports/rapport_ability.jasper", abilityDataSource);
            LOG.debug("pdfArray: inainte de pdfByteArray");
            pdfByteArray = JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (JRException e) {
            LOG.error("pdfArray: Error creating the report", e);
        }
        return pdfByteArray;
    }

    public static byte[] txtArray(Long id, String title) {
        JasperPrint jasperPrint;
        byte[] pdfByteArray = null;

        LOG.debug("process file---------id = " + id);

        AbilityDataSource abilityDataSource = new AbilityDataSource(title);
        Reports report = new Reports();
        if (id != null) {
            try {
                jasperPrint = report.generateReport("/reports/rapport_ability.jasper", abilityDataSource);
                LOG.debug("pdfArray: inainte de pdfByteArray");

                JRCsvExporter exporter = new JRCsvExporter();
                exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, ";");
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
                exporter.exportReport();
                pdfByteArray = baos.toByteArray();
                String aString = new String(pdfByteArray, "UTF-8");
                pdfByteArray = aString.getBytes("Cp1250");
            } catch (Exception e) {
                LOG.error("pdfArray: Error creating the report", e);
            }
        }
        return pdfByteArray;
    }

    public static void processFile(HttpServletRequest request, HttpServletResponse response) {

        ServletOutputStream out;
        try {
            Long id = Long.valueOf(request.getParameter("id"));
        } catch (NumberFormatException nfe) {
        }

        String title = request.getParameter("reportTitle");
        LOG.debug("-------------------->>>processFile : title= " + title);

        response.setContentType("application/pdf");
        //response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "filename=\"abilities.pdf\"");

        try {
            out = response.getOutputStream();
            out.write(pdfArray(title));
            out.flush();
            out.close();
        } catch (IOException e) {
            LOG.error("Error writing report output", e);
        }

    }
}
