package br.com.Rsinet.Hub.BDD.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Home_BuscardeProduto_Tela_Principal {

	private static WebDriver driver;
	private static WebElement element = null;

	public Home_BuscardeProduto_Tela_Principal(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[@id='laptopsImg']")
	private WebElement mouse;

	/*
	 * public static WebElement mouse(WebDriver driver) { element =
	 * driver.findElement(By.xpath("//div[@id='laptopsImg']")); // WebDriverWait
	 * wait = new WebDriverWait(driver, 10); //
	 * wait.until(ExpectedConditions.elementToBeClickable(element));
	 * JavascriptExecutor ex = (JavascriptExecutor) driver;
	 * ex.executeScript("arguments[0].click();", element); return element; }
	 */

	@FindBy(how = How.ID, using = "3")
	private WebElement produto;

	/*
	 * public static WebElement produto(WebDriver driver) {
	 * 
	 * try { element = driver.findElement(By.id("3"));
	 * 
	 * } catch (Exception e) { } Assert.assertNotNull(element);
	 * System.out.println("Ending test " + new Object() {
	 * }.getClass().getEnclosingMethod().getName());
	 * 
	 * return element; }
	 */

	@FindBy(how = How.XPATH, using = "//div[@class='cell categoryRight']//li[@class='ng-scope']")
	private WebElement Adicionarlaptop;

	@FindBy(how = How.XPATH, using = "//div[@id='Description']//div[2]//span[1]")
	private WebElement Cordoproduto;

	@FindBy(how = How.NAME, using = "save_to_cart")
	private WebElement Confirmar;

	@FindBy(how = How.ID, using = "checkOutPopUp")
	private WebElement Carinhopop;

	public void telaprincipa() {
		mouse.click();
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", element);
	}

	public void produto_Laptop() {
		produto.click();
	}

	public void Adicionar_Laptop() {
		Adicionarlaptop.click();
	}

	public void escolhendoCor() {
		Cordoproduto.click();
	}

	public void Confirmando() {
		Confirmar.click();
	}

	public void ProdutonoCarinho() {
		Carinhopop.click();
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", element);
	}

}
