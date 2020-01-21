Feature: Buscando pela tela inicial

Background:
	Given entrar no site para se iniciar
	When  clicar na tela incial onde tem o laptop
	
@TelaTestepositivo
Scenario: Burcar o produto pelo id 
Then selecionar ele pelo elemento id 
	
@TelaTestenegativo
Scenario: Nao encontrou o produto pelo id
	Then  Nao encontrou o produto certo pelo id
	