package br.com.Rsinet.Hub.BDD.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.Rsinet.Hub.BDD.Utility.Constant;
import br.com.Rsinet.Hub.BDD.Utility.ExcelUtils;

public class Home_Cadastro_de_Usuario {

	private static WebDriver driver;
	private static WebElement element = null;

	public Home_Cadastro_de_Usuario(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "menuUserSVGPath")
	private WebElement clicarmenu;

	@FindBy(how = How.XPATH, using = "//a[@class='create-new-account ng-scope']")
	private WebElement clicarCadastrar;

	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	private WebElement nomeUsuario;

	@FindBy(how = How.NAME, using = "emailRegisterPage")
	private WebElement emailUsuario;

	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	private WebElement senhaUsuario;

	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	private WebElement confirmasenhaUsuario;

	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	private WebElement primeiroNome;

	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	private WebElement ultimoNome;

	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	private WebElement telefoneUsuario;

	@FindBy(how = How.NAME, using = "countryListboxRegisterPage")
	private WebElement paisUsuario;

	@FindBy(how = How.NAME, using = "cityRegisterPage")
	private WebElement cidadeUsuario;

	@FindBy(how = How.NAME, using = "addressRegisterPage")
	private WebElement enderecoUsuario;

	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
	private WebElement estadoUsuario;

	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	private WebElement cepUsuario;

	@FindBy(how = How.NAME, using = "allowOffersPromotion")
	private WebElement aceitaprimeiroTermos;

	@FindBy(how = How.NAME, using = "i_agree")
	private WebElement aceitasegundoTermos;

	@FindBy(how = How.NAME, using = "register_btnundefined")
	private WebElement registraUsuario;

	public void menu() {
		clicarmenu.click();
	}

	public void cadastrar() {
		clicarCadastrar.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor ex = (JavascriptExecutor) driver;

		ex.executeScript("arguments[0].click();", element);
	}

	public void nome_usuario(String sNome) {
		nomeUsuario.sendKeys(sNome);
	}

	public void email_usuario(String sEmail) {
		emailUsuario.sendKeys(sEmail);
	}

	public void senha_usuario(String sSenha) {
		senhaUsuario.sendKeys(sSenha);
	}

	public void confirmar_senha(String sSenha) {
		confirmasenhaUsuario.sendKeys(sSenha);
	}

	public void primeiro_nome(String sPrimeironome) {
		primeiroNome.sendKeys(sPrimeironome);
	}

	public void ultimo_nome(String sUltimonome) {
		ultimoNome.sendKeys(sUltimonome);
	}

	public void telefone_usuario(String sTelefone) {
		telefoneUsuario.sendKeys(sTelefone);
	}

	public void pais_Usuario(String sPais) {
		paisUsuario.sendKeys(sPais);
		new Select(element).selectByVisibleText("Brazil");
	}

	public void cidade_usuario(String sCidade) {
		cidadeUsuario.sendKeys(sCidade);
	}

	public void endereco_usuario(String sEndereco) {
		enderecoUsuario.sendKeys(sEndereco);
	}

	public void estado_usuario(String sEstado) {
		estadoUsuario.sendKeys(sEstado);
	}

	public void cep_usuario(String sCep) {
		cepUsuario.sendKeys(sCep);
	}

	public void acaitaTermos_1() {
		aceitaprimeiroTermos.isSelected();
	}

	public void aceitatermos_2() {
		aceitasegundoTermos.click();
	}

	public void regristra_uruario() {
		registraUsuario.click();
	}

	@SuppressWarnings("unused")
	public void chamando_trings() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");

		String sNome = ExcelUtils.getCellData(1, 0);
		String sEmail = ExcelUtils.getCellData(1, 1);
		String sSenha = ExcelUtils.getCellData(1, 2);
		String sPrimeironome = ExcelUtils.getCellData(1, 3);
		String sUltimonome = ExcelUtils.getCellData(1, 4);
		String sTelefone = ExcelUtils.getCellData(1, 5);
		String sCidade = ExcelUtils.getCellData(1, 6);
		String sPais = ExcelUtils.getCellData(1, 7);
		String sEndereco = ExcelUtils.getCellData(1, 8);
		String sEstado = ExcelUtils.getCellData(1, 9);
		String sCep = ExcelUtils.getCellData(1, 10);

	}
}
