package br.com.Rsinet.Hub.BDD.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.Rsinet.Hub.BDD.Utility.Constant;

public class Home_ChromeDriver {

	private static WebDriver driver;
	

	public static WebDriver InicializaDriver() {
		driver = new ChromeDriver();
		driver.get(Constant.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}

	public static void FechandoDriver(WebDriver driver) {
		
	
		if (driver != null)
			driver.quit();
	
	}

}
