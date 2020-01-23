package br.com.Rsinet.Hub.BDD.TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature/Cadastro_Usuario.feature", 
		glue = { "br.com.Rsinet.Hub.BDD"}
		)
		
public class Test_Runner_TelaInicial {

}
