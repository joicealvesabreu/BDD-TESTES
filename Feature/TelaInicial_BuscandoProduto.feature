Feature: Buscando um produto pela tela de inicio

Background: Vai entrar no site e cliclar na imagem dos laptops
	 Given iniciando o chromedriver para entrar no site
    When colocando o produto no carinho
 
  @tag1
  Scenario: vai buscar o laptop escolhido peçlo elemento
    Then sera feito o processo de acessar o produto que foi escolhindo e ver se e o certo
   

  @tag2
  Scenario: vai comparar o elemento e ver que o produto nao e o certo
  	Then sera verificado se o produto correnponde se nao for sera false
  


  
