package com.aniket.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ReportPathInitializer {
    public static void setupReport() throws IOException{
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/extent.properties");
        prop.load(fis);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = "test-output/ExtentReports/Spark_" + timeStamp + ".html";
        prop.setProperty("report.path", reportPath);
        System.out.println("property set");
    }
}
