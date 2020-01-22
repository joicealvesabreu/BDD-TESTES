package br.com.Rsinet.Hub.BDD.Testes;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.Rsinet.Hub.BDD.PageObjects.Home_BuscardeProduto_Tela_Principal;
import br.com.Rsinet.Hub.BDD.PageObjects.Home_ChromeDriver;
import br.com.Rsinet.Hub.BDD.Utility.PrintScreen;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tela_Inicial_PesquisadeProduto {
	WebDriver driver;
	Home_BuscardeProduto_Tela_Principal home;

	ExtentReports extent;
	ExtentTest logger, logger1;
	ExtentHtmlReporter reporter;
	
	@Given("^iniciando o chromedriver para entrar no site$")
	public void iniciando_o_chromedriver_para_entrar_no_site() throws Throwable {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Relatorios/BuscandoProduto_TelaInicial.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		driver = Home_ChromeDriver.InicializaDriver();
		home = PageFactory.initElements(driver,Home_BuscardeProduto_Tela_Principal.class);
	}

	@When("^colocando o produto no carinho$")
	public void colocando_o_produto_no_carinho() throws Throwable {
		logger = extent.createTest("produto selecionado");
		logger1 = extent.createTest("Nao é o produto esperado");
		home.telaprincipal();
		home.produto_Laptop();
		String clicoucerto = driver.getCurrentUrl();
		Assert.assertTrue(clicoucerto.contains("https://www.advantageonlineshopping.com/#/product/3"));
		
	}

	@Then("^sera feito o processo de acessar o produto que foi escolhindo e ver se e o certo$")
	public void sera_feito_o_processo_de_acessar_o_produto_que_foi_escolhindo_e_ver_se_e_o_certo() throws Throwable {
		home.Adicionar_Laptop();
		home.escolhendoCor();
		PrintScreen.getScreenshot(driver);
		logger.log(Status.PASS, "Encontrou");
		extent.flush();
		Home_ChromeDriver.FechandoDriver(driver);
	}

	@Then("^sera verificado se o produto correnponde se nao for sera false$")
	public void sera_verificado_se_o_produto_correnponde_se_nao_for_sera_false() throws Throwable {
		boolean achouprodutoerrado = driver.getPageSource().contains("HP ZEN BOOK");
		Assert.assertFalse(achouprodutoerrado);
		PrintScreen.getScreenshot(driver);
		logger1.log(Status.PASS, "Nao Encontrou");
		extent.flush();
		Home_ChromeDriver.FechandoDriver(driver);
		
	}
	

}
