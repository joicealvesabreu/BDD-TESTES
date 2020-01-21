package br.com.Rsinet.Hub.BDD.Testes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import br.com.Rsinet.Hub.BDD.PageObjects.Home_ChromeDriver;
import br.com.Rsinet.Hub.BDD.PageObjects.Home_PesquisandoProduto_Lupa;
import br.com.Rsinet.Hub.BDD.Utility.Constant;
import br.com.Rsinet.Hub.BDD.Utility.ExcelUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Busca_Por_Pesquisa {
	WebDriver driver;
	Home_PesquisandoProduto_Lupa home;
	Home_ChromeDriver homedriver;

	@Given("^entrar no site$")
	public void entrar_no_site() throws Throwable {
		driver = Home_ChromeDriver.InicializaDriver();
		home = PageFactory.initElements(driver, Home_PesquisandoProduto_Lupa.class);
	}

	@When("^clicar na  barra de pesquisa$")
	public void clicar_na_barra_de_pesquisa() throws Throwable {
		home.Pesquisa();
	}

	@When("^escrever o nome do produto$")
	public void escrever_o_nome_do_produto() throws Throwable {
		home.ProdutoPesquisado();
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		boolean achouNome = driver.getPageSource().contains(ExcelUtils.getCellData(1, 11));

		Assert.assertTrue(achouNome);
		System.out.println(achouNome);
	}

	@Then("^Achou o produto$")
	public void achou_o_produto() throws Throwable {
		home.Adicionarlaptop();
		home.Confirmandolaptop();
		home.Cordolaptop();
		home.Selecionandoaocarinho();
		home.Carinhopop();
		Home_ChromeDriver.FechandoDriver(driver);
	}

	@Then("^Nao encontrou o produto$")
	public void n_o_encontrou_o_produto() throws Throwable {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		boolean produtoerrado = driver.getPageSource().contains(ExcelUtils.getCellData(1, 12));
		Assert.assertFalse(produtoerrado);
		System.out.println(produtoerrado);
		Home_ChromeDriver.FechandoDriver(driver);
	
		
	}

}
