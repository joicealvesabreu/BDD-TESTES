package br.com.Rsinet.Hub.BDD.Testes;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature", glue = { "stepDefinition" })

public class Test_Runner_Cadastro {

@Given("^eu esteja na tela principal$")
public void eu_esteja_na_tela_principal() throws Throwable {
   
}

@When("^eu acessar o menu cadastrar perfil$")
public void eu_acessar_o_menu_cadastrar_perfil() throws Throwable {
   
}

@When("^informar o nome$")
public void informar_o_nome() throws Throwable {
   
}

@When("^informar o e-mail$")
public void informar_o_e_mail() throws Throwable {
    
}

@When("^informar a senha$")
public void informar_a_senha() throws Throwable {
   
}

@When("^confirmar a senha$")
public void confirmar_a_senha() throws Throwable {
    
}

@When("^informae o sobrenome$")
public void informae_o_sobrenome() throws Throwable {
   
}

@When("^informar o telefone$")
public void informar_o_telefone() throws Throwable {
    
}

@When("^Selecionar o pais$")
public void selecionar_o_pais() throws Throwable {
   
}

@When("^informar a cidade$")
public void informar_a_cidade() throws Throwable {
    
}

@When("^informar a rua$")
public void informar_a_rua() throws Throwable {
   
}

@When("^informar o cep$")
public void informar_o_cep() throws Throwable {
   
}

@When("^selecionar o primeiro termo$")
public void selecionar_o_primeiro_termo() throws Throwable {
    
}

@When("^Aceitar o segundo termo$")
public void aceitar_o_segundo_termo() throws Throwable {
    
}

@When("^o usuario e registrado no sistema$")
public void o_usuario_e_registrado_no_sistema() throws Throwable {
   
}

@Then("^e vai estar ativo$")
public void e_vai_estar_ativo() throws Throwable {
   
}
}
