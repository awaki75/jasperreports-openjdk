package io.github.awaki75.jasperreportsopenjdk;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class Main {

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    private void run() throws IOException, JRException {
        try (InputStream inputStream = this.getClass().getResourceAsStream("/hello.jrxml")) {
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    jasperReport, new HashMap<String, Object>(), new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(jasperPrint, "hello.pdf");
        }
    }
}
