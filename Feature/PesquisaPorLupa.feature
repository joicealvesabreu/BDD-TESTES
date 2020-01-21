Feature: Buscar um produto 

Background:
	Given entrar no site
	When  clicar na  barra de pesquisa
	And  escrever o nome do produto 
	
@Testepositivo
Scenario: BuScar um produto com dados de massa
Then Achou o produto
	
@Testenegativo
Scenario: BuScar um produto com dados de massa ele nao existirar
	Then  Nao encontrou o produto
	