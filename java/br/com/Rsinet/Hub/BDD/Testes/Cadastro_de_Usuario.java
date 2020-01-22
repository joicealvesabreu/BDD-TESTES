package br.com.Rsinet.Hub.BDD.Testes;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.Rsinet.Hub.BDD.PageObjects.Home_Cadastro_de_Usuario;
import br.com.Rsinet.Hub.BDD.PageObjects.Home_ChromeDriver;
import br.com.Rsinet.Hub.BDD.Utility.Constant;
import br.com.Rsinet.Hub.BDD.Utility.ExcelUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Cadastro_de_Usuario {
	WebDriver driver;
	Home_Cadastro_de_Usuario pesquisa;
	ExtentReports extent;
	ExtentTest logger, logger1;
	ExtentHtmlReporter reporter;

	@Given("^tela principal do site$")
	public void tela_principal_do_site() throws Throwable {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Relatorios/CadastrodeuSsuario123456.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		driver = Home_ChromeDriver.InicializaDriver();
		pesquisa = PageFactory.initElements(driver, Home_Cadastro_de_Usuario.class);

	}

	@When("^menu de usuario para cadastrar$")
	public void menu_de_usuario_para_cadastrar() throws Throwable {
		logger = extent.createTest("Cadastrou");
		logger1 = extent.createTest("Cadastroj·Existe");
		pesquisa.menu();
		pesquisa.cadastrar();
	}

	@When("^preencher o formulario do  cadastro$")
	public void preencher_o_formulario_do_cadastro() throws Throwable {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");

		String sNome = ExcelUtils.getCellData(2, 0);
		pesquisa.nome_usuario(sNome);
		String sEmail = ExcelUtils.getCellData(1, 1);
		pesquisa.email_usuario(sEmail);
		String sSenha = ExcelUtils.getCellData(1, 2);
		pesquisa.senha_usuario(sSenha);
		pesquisa.confirmar_senha(sSenha);
		String sPrimeironome = ExcelUtils.getCellData(1, 3);
		pesquisa.primeiro_nome(sPrimeironome);
		String sUltimonome = ExcelUtils.getCellData(1, 4);
		pesquisa.ultimo_nome(sUltimonome);
		String sTelefone = ExcelUtils.getCellData(1, 5);
		pesquisa.telefone_usuario(sTelefone);
		String sCidade = ExcelUtils.getCellData(1, 6);
		pesquisa.cidade_usuario(sCidade);
		pesquisa.pais_Usuario();
		String sEndereco = ExcelUtils.getCellData(1, 8);
		pesquisa.endereco_usuario(sEndereco);
		String sEstado = ExcelUtils.getCellData(1, 9);
		pesquisa.estado_usuario(sEstado);
		String sCep = ExcelUtils.getCellData(1, 10);
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
		logger.log(Status.PASS, "Sucesso");
		extent.flush();
		Home_ChromeDriver.FechandoDriver(driver);
	}

	@Then("^mensagem de erro ja existe um cadastro$")
	public void mensagem_de_erro_ja_existe_um_cadastro() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,200)");
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");

		String cadastrojaexiste = driver
				.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]")).getText();
		Assert.assertTrue(cadastrojaexiste.contains("User name already exists"));
		System.out.println(cadastrojaexiste);
		logger1.log(Status.PASS, "Usuario ja È cadastrado");
		extent.flush();
		Home_ChromeDriver.FechandoDriver(driver);
	}

}
