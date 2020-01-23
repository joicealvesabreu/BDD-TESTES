Feature: Buscar um produto por massa de dados

Background: Aqui vai entrar no site e buscar um produto pela lupa de pesquisa
	Given entrar no site
	When  clicar na  barra de pesquisa
	And  escrever o nome do produto 
	
@Testepositivo
Scenario: Buscar um produto com dados de massa puxando a informacao do excel
Then Achou o produto
	
@Testenegativo
Scenario: Buscar um produto com dados de massa ele nao existirar
	Then  Nao encontrou o produto
	