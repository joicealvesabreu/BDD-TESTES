#language: pt
Funcionalidade: Realizar um  cadastro 

Contexto: Ter� que entra no site e ciclar na parte de cadastrar novo usuario

Dado  na tela principal do site
Quando ir ao menu e cliclar em cadastrar novo usu�rio


@Cadastro_Sucesso
Cen�rio: Fazer um cadastro com sucesso
	E  prencher o nome 
	E  prencher o email
	E  prencher a senha
	E  preencher a comfirmacao da senha
	E  prencher o primeiro nome
	E  preencher o sobrenome
	E  Preencher o telefone
	E  preencher o  pa�s
	E  preencher a cidade
	E  preencher o endere�o
	E  preencher o estado
	E  preencher o cep
	Quando clicar para aceitar os termos 
	E clicar em registrar
	Ent�o entrarar na conta do usuario que foi cadastrado com sucesso

@Cadastrojaexiste
Cen�rio: Fazer um cadastro, por�m ele j� estar cadastrado
	E  prencher o nome 
	E  prencher o email
	E  prencher a senha
	E  preencher a comfirmacao da senha
	E  prencher o primeiro nome
	E  preencher o sobrenome
	E  Preencher o telefone
	E  preencher o  pa�s
	E  preencher a cidade
	E  preencher o endere�o
	E  preencher o estado
	E  preencher o cep
	Quando clicar para aceitar os termos 
	E clicar em registrar
	Ent�o ter� que dar uma mensagem que de o usuario j� existe 

