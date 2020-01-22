package br.com.Rsinet.Hub.BDD.Testes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import br.com.Rsinet.Hub.BDD.PageObjects.Home_ChromeDriver;
import br.com.Rsinet.Hub.BDD.PageObjects.Home_PesquisandoProduto_Lupa;
import br.com.Rsinet.Hub.BDD.Utility.Constant;
import br.com.Rsinet.Hub.BDD.Utility.ExcelUtils;
import br.com.Rsinet.Hub.BDD.Utility.PrintScreen;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Pesquisa_Por_Lupa {
	WebDriver driver;
	Home_PesquisandoProduto_Lupa home;
	Home_ChromeDriver homedriver;
	ExtentReports extent;
	ExtentTest logger, logger1;
	ExtentHtmlReporter reporter;

	@Given("^entrar no site$")
	public void entrar_no_site() throws Throwable {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Relatorios/PesquisaPorMassaDeDados.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		driver = Home_ChromeDriver.InicializaDriver();
		home = PageFactory.initElements(driver, Home_PesquisandoProduto_Lupa.class);
	}

	@When("^clicar na  barra de pesquisa$")
	public void clicar_na_barra_de_pesquisa() throws Throwable {
		logger = extent.createTest("Buscardeproduto_Certo");
		logger1 = extent.createTest("Produto_Errado ");
		home.Pesquisa();
	}

	@When("^escrever o nome do produto$")
	public void escrever_o_nome_do_produto() throws Throwable {
		home.ProdutoPesquisado();
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		boolean achouNome = driver.getPageSource().contains(ExcelUtils.getCellData(1, 11));

	}

	@Then("^Achou o produto$")
	public void achou_o_produto() throws Throwable {

		home.Adicionarlaptop();
		home.Confirmandolaptop();
		home.Cordolaptop();
		home.Selecionandoaocarinho();
		home.Carinhopop();
		boolean achouNome = driver.getPageSource().contains(ExcelUtils.getCellData(1, 11));
		Assert.assertTrue(achouNome);
		System.out.println(achouNome);
		PrintScreen.getScreenshot(driver);
		logger.log(Status.PASS, "Sucesso");
		extent.flush();
		Home_ChromeDriver.FechandoDriver(driver);
	}

	@Then("^Nao encontrou o produto$")
	public void n_o_encontrou_o_produto() throws Throwable {

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		boolean produtoerrado = driver.getPageSource().contains(ExcelUtils.getCellData(1, 12));
		Assert.assertFalse(produtoerrado);
		System.out.println(produtoerrado);
		PrintScreen.getScreenshot(driver);
		logger1.log(Status.PASS, "Nao Encontrou");
		extent.flush();
		Home_ChromeDriver.FechandoDriver(driver);
	}


}
