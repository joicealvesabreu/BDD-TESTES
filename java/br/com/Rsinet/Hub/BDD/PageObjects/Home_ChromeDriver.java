package br.com.Rsinet.Hub.BDD.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
