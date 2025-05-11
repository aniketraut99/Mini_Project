package com.aniket.Utils;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.Scenario;

public class ExtentManager {
    private static ExtentReports extent;
    public static ExtentReports getInstance(){
        if(extent==null){
            extent = new ExtentReports();
            String timeStamp= new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportPath = "test-output/ExtentReports/Spark_" + timeStamp + ".html";
            ExtentSparkReporter sparkReporter= new ExtentSparkReporter(reportPath);
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }

}