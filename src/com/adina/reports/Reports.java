package com.adina.reports;

import com.adina.reports.util.ReportsUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Reports {
    private static final Logger LOG = Logger.getLogger(Reports.class);

    private static final String DEFAULT_JASPER_PRINT_NAME = "rapport";

    public JasperPrint generateReport(final String jasperFileName, final JRDataSource dataSource) {
        try {
            Object object = JRLoader.loadObjectFromLocation(jasperFileName);
            JasperReport jasperReport = (JasperReport) object;

            return JasperFillManager.fillReport(jasperReport, getParams(), dataSource);

        } catch (JRException e) {
            e.printStackTrace();
        }

        return null;
    }

    public JasperPrint generateReportJasperDesign(final JasperDesign jasperDesignFile, final JRDataSource dataSource) {
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesignFile);

            return JasperFillManager.fillReport(jasperReport, getParams(), dataSource);

        } catch (JRException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected Map getParams() {
        Map parameters = new HashMap();
        parameters.put(JRParameter.REPORT_LOCALE, Locale.ENGLISH);
        return parameters;
    }

    public static byte[] exportJasperPrintToFileFormat(JasperPrint jasperPrint, String format) throws JRException {
        JRExporter exporter = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        if ("".equals(format) && (!format.equals(ReportsUtil.FORMAT_PDF) || !format.equals(ReportsUtil.FORMAT_XLS))) {
            format = ReportsUtil.FORMAT_PDF;  //default format = PDF
        }
        if (format.equals(ReportsUtil.FORMAT_PDF)) {
            exporter = new JRPdfExporter();
        }

        if (format.equals(ReportsUtil.FORMAT_XLS)) {
            exporter = new JRXlsExporter();
            exporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
            exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
            exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN, Boolean.TRUE);
        }

        if (jasperPrint.getName().length() > 31) {
            LOG.warn("Sheet name cannot be blank, greater than 31 chars, or contain any of /\\*?[]");
            jasperPrint.setName(DEFAULT_JASPER_PRINT_NAME);
        }
        if (exporter != null) {
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.exportReport();
        }

        return outputStream.toByteArray();
    }
}
