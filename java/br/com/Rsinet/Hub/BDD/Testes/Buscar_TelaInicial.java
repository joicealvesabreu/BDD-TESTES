package br.com.Rsinet.Hub.BDD.Testes;



import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.Rsinet.Hub.BDD.PageObjects.Home_BuscardeProduto_Tela_Principal;
import br.com.Rsinet.Hub.BDD.PageObjects.Home_ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Buscar_TelaInicial {

	WebDriver driver;
	Home_BuscardeProduto_Tela_Principal telaPrincipal;
	Home_ChromeDriver homedriver;

	@Given("^entrar no site para se iniciar$")
	public void entrar_no_site_para_se_iniciar() throws Throwable {
		driver = Home_ChromeDriver.InicializaDriver();
		telaPrincipal = PageFactory.initElements(driver, Home_BuscardeProduto_Tela_Principal.class);
	}

	@When("^clicar na tela incial onde tem o laptop$")
	public void clicar_na_tela_incial_onde_tem_o_laptop() throws Throwable {
		telaPrincipal.telaprincipa();
		telaPrincipal.produto_Laptop();
		String clicoucerto = driver.getCurrentUrl();
		Assert.assertTrue(clicoucerto.contains("https://www.advantageonlineshopping.com/#/product/3"));
		
	}

	@Then("^selecionar ele pelo elemento id$")
	public void selecionar_ele_pelo_elemento_id() throws Throwable {
		telaPrincipal.Adicionar_Laptop();
		telaPrincipal.escolhendoCor();
		telaPrincipal.Confirmando();
		telaPrincipal.ProdutonoCarinho();
		Home_ChromeDriver.FechandoDriver(driver);
	}

	@Then("^Nao encontrou o produto certo pelo id$")
	public void nao_encontrou_o_produto_certo_pelo_id() throws Throwable {
		telaPrincipal.produto_Laptop();
		String clicoucerto = driver.getCurrentUrl();
		Assert.assertFalse(clicoucerto.contains("https://www.advantageonlineshopping.com/#/product/24"));
		Home_ChromeDriver.FechandoDriver(driver);

	}

}
