package br.com.Rsinet.Hub.BDD.PageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.Rsinet.Hub.BDD.Utility.Constant;
import br.com.Rsinet.Hub.BDD.Utility.ExcelUtils;

public class Home_PesquisandoProduto_Lupa {

	WebDriver driver;
	WebElement element = null;

	public Home_PesquisandoProduto_Lupa(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "menuSearch")
	private WebElement BarradePesquisa;

	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement Buscandoproduto;
	
	@FindBy(how = How.XPATH, using = "//div[@class='autoCompleteCover']//div//img")
	private WebElement FechandoBotao;
	
	@FindBy(how = How.XPATH, using = "//div[@class='cell categoryRight']//li[@class='ng-scope']")
	private WebElement clicarlaptop;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div/div/div[2]/ul/li/div[2]/label")
	private WebElement Confirmar;
	
	
	@FindBy(how = How.XPATH, using = "//span[@class='productColor ng-scope colorSelected BLACK']")
	private WebElement Cor;
	
	@FindBy(how = How.NAME, using = "save_to_cart")
	private WebElement Selecionar;
	
	@FindBy(how = How.ID, using = "checkOutPopUp") // Name = check_out_btn
	private WebElement Carinho;

	public void Pesquisa() {
		BarradePesquisa.click();
	}
	
	public void ProdutoPesquisado() throws Exception {
		 ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		Buscandoproduto.sendKeys(ExcelUtils.getCellData(1, 11) + Keys.ENTER);
		
	}
	

	public void Botaofechar() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement elemento = FechandoBotao;
		ex.executeScript("arguments[0].click();", elemento);
	}

	public void Adicionarlaptop() {
		clicarlaptop.click();
	}

	public void Confirmandolaptop() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement elemento =	Confirmar;
		ex.executeScript("arguments[0].click();", elemento);
	}

	public void Cordolaptop() {
		Cor.click();
	}

	public void Selecionandoaocarinho() {
		Selecionar.click();
	}

	public void Carinhopop() {
		Carinho.sendKeys(Keys.ENTER);
	}
}
