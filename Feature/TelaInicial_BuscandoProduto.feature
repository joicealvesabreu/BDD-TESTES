Feature: Tela inicial do site advance

Background: iniciando os dois testes
	 Given iniciando o chromedriver para entrar no site
    When colocando o produto no carinho
 
  @tag1
  Scenario: cenario certo
    Then sera feito o processo de acessar o produto que foi escolhindo e ver se e o certo
   

  @tag2
  Scenario: scenario produto errado
  	Then sera verificado se o produto correnponde se nao for sera false
  


  
