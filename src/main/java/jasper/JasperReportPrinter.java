package jasper;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JsonDataSource;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;

public class JasperReportPrinter {

    public static void main(String[] args) {
        try {
            String jrxmlFile = "spd_import_report.jrxml";
            String jsonFile = "spd_import_report_test.json";
            String outputPdfFile = "output_report.pdf";

            ClassLoader classLoader = JasperReportPrinter.class.getClassLoader();
            InputStream jrxmlStream = classLoader.getResourceAsStream(jrxmlFile);
            InputStream jsonStream = classLoader.getResourceAsStream(jsonFile);

            if (jrxmlStream == null || jsonStream == null) {
                System.err.println("Файлы не найдены в resources!");
                return;
            }

            JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlStream);

            JsonDataSource dataSource = new JsonDataSource(jsonStream);

            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    jasperReport,
                    new HashMap<>(),
                    dataSource
            );

            JasperExportManager.exportReportToPdfFile(jasperPrint, outputPdfFile);

            System.out.println("PDF успешно создан: " + new File(outputPdfFile).getAbsolutePath());

            jrxmlStream.close();
            jsonStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
