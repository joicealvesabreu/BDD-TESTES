package br.com.Rsinet.Hub.BDD.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports {
	
	ExtentReports extent;
	ExtentTest logger;
	ExtentHtmlReporter reporter;
	
	
	public void setExtent() {
		
				reporter = new ExtentHtmlReporter (System.getProperty("user.dir")+"/Relatorios/Reports.html");
				reporter.config().setDocumentTitle("Automatico report");
				reporter.config().setReportName("funcional report");
				reporter.config().setTheme(Theme.DARK);
				
				extent = new ExtentReports();
				
				extent.attachReporter(reporter);
				
				extent.setSystemInfo("Hostname", "LocalHost");
				extent.setSystemInfo("Os", "Windows10");
				extent.setSystemInfo("Browser", "Chrome");
				
	}
	
	public void AndReport() {
		
		extent.flush();
   }
	
	
	
	
	
	
	
	
	
	
	
	
}
