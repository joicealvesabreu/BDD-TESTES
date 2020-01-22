package br.com.Rsinet.Hub.BDD.Testes;


import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.Rsinet.Hub.BDD.PageObjects.Home_Cadastro_de_Usuario;
import br.com.Rsinet.Hub.BDD.PageObjects.Home_ChromeDriver;
import br.com.Rsinet.Hub.BDD.Utility.Constant;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Cadastro_de_Usuario {
	WebDriver driver;
	 Home_Cadastro_de_Usuario pesquisa;
	 
	 
	
	@Given("^tela principal do site$")
	public void tela_principal_do_site() throws Throwable {
		driver = Home_ChromeDriver.InicializaDriver();
		pesquisa = PageFactory.initElements(driver,Home_Cadastro_de_Usuario.class);
		
	}

	@When("^menu de usuario para cadastrar$")
	public void menu_de_usuario_para_cadastrar() throws Throwable {
		pesquisa.menu();
		pesquisa.cadastrar();
	}

	@When("^preencher o formulario do  cadastro$")
	public void preencher_o_formulario_do_cadastro() throws Throwable {
		
		String sNome = Constant.sNome;
	    pesquisa.nome_usuario(sNome);
		String sEmail = Constant.sEmail;
		pesquisa.email_usuario(sEmail);
		String sSenha = Constant.sSenha;
		pesquisa.senha_usuario(sSenha);
		pesquisa.confirmar_senha(sSenha);
		String sPrimeironome = Constant.sPrimeironome;
		pesquisa.primeiro_nome(sPrimeironome);
		String sUltimonome = Constant.sUltimonome;
		pesquisa.ultimo_nome(sUltimonome);
		String sTelefone = Constant.sTelefone;
		pesquisa.telefone_usuario(sTelefone);
		String sCidade = Constant.sCidade;
		pesquisa.cidade_usuario(sCidade);
		// String sPais = Constant.sPais;
		pesquisa.pais_Usuario();
		String sEndereco = Constant.sEndereco;
		pesquisa.endereco_usuario(sEndereco);
		String sEstado = Constant.sEstado;
		pesquisa.estado_usuario(sEstado);
		String sCep = Constant.sCep;
		pesquisa.cep_usuario(sCep);
	}

	@When("^regritar no sistema com o aceite$")
	public void regritar_no_sistema_com_o_aceite() throws Throwable {
		pesquisa.aceitaTermos_1();
		   pesquisa.aceitatermos_2();
		   pesquisa.regristra_usuario();
	}

	@Then("^entrar na conta que acabou de ser cadastrada$")
	public void entrar_na_conta_que_acabou_de_ser_cadastrada() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String sNome = Constant.sNome;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menuUserLink\"]/span"))).getText();

		Assert.assertTrue(driver.getPageSource().contains(sNome));
		System.out.println(wait);
	}

	@Then("^mensagem de erro ja existe um cadastro$")
	public void mensagem_de_erro_ja_existe_um_cadastro() throws Throwable {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,200)");
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");

		String cadastrojaexiste = driver
				.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]")).getText();
		Assert.assertTrue(cadastrojaexiste.contains("User name already exists"));
		System.out.println( cadastrojaexiste);
	}
	@AfterClass
	public void Finalizar() {
		Home_ChromeDriver.FechandoDriver(driver);
	}
	

}
