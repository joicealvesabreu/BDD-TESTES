package br.com.Rsinet.Hub.BDD.Testes;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.Rsinet.Hub.BDD.PageObjects.Home_BuscardeProduto_Tela_Principal;
import br.com.Rsinet.Hub.BDD.PageObjects.Home_ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tela_Inicial_PesquisadeProduto {
	WebDriver driver;
	Home_BuscardeProduto_Tela_Principal home;
	Home_ChromeDriver homedriver;
	ExtentReports extent;
	ExtentTest logger, logger1;
	ExtentHtmlReporter reporter;
	
	@Given("^inicia o testes com chomerdriver$")
	public void inicia_o_testes_com_chomerdriver() throws Throwable {
		driver = Home_ChromeDriver.InicializaDriver();
		home = PageFactory.initElements(driver, Home_BuscardeProduto_Tela_Principal.class);
	}

	@When("^Procurando o produto correto$")
	public void procurando_o_produto_correto() throws Throwable {
		home.telaprincipal();
		home.produto_Laptop();
		String clicoucerto = driver.getCurrentUrl();
		Assert.assertTrue(clicoucerto.contains("https://www.advantageonlineshopping.com/#/product/3"));
		home.Adicionar_Laptop();
		home.escolhendoCor();
		}

	@Then("^finaliza com assert$")
	public void finaliza_com_assert() throws Throwable {
		home.Confirmando();
		home.ProdutonoCarinho();
		Home_ChromeDriver.FechandoDriver(driver);
	}

	@When("^procurar pelo produto errado$")
	public void procurar_pelo_produto_errado() throws Throwable {
		home.telaprincipal();
		home.produto_Laptop();
		
	}

	@Then("^vai finalizar  aparecer a url errada$")
	public void vai_finalizar_aparecer_a_url_errada() throws Throwable {
	boolean achouprodutoerrado = driver.getPageSource().contains("HP ZEN BOOK");
	Assert.assertFalse(achouprodutoerrado);
	Home_ChromeDriver.FechandoDriver(driver);
		
	}
}
