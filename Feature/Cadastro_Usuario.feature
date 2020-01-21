Feature: Realizar um  cadastro

Background:

Given tela principal do site
When  menu de usuario para cadastrar
And  preencher o formulario do  cadastro
And regritar no sistema com o aceite

@TestePositivo
Scenario: Fazer um cadastro com sucesso
	Then entrar na conta que acabou de ser cadastrada

@TesteNegativo
Scenario:Fazer um cadastro com falha, pois ele ja estara cadastrado

	Then mensagem de erro ja existe um cadastro

