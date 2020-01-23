#language: pt
Funcionalidade: Realizar um  cadastro 

Contexto: Terá que entra no site e ciclar na parte de cadastrar novo usuario

Dado  na tela principal do site
Quando ir ao menu e cliclar em cadastrar novo usuário


@Cadastro_Sucesso
Cenário: Fazer um cadastro com sucesso
	E  prencher o nome 
	E  prencher o email
	E  prencher a senha
	E  preencher a comfirmacao da senha
	E  prencher o primeiro nome
	E  preencher o sobrenome
	E  Preencher o telefone
	E  preencher o  país
	E  preencher a cidade
	E  preencher o endereço
	E  preencher o estado
	E  preencher o cep
	Quando clicar para aceitar os termos 
	E clicar em registrar
	Então entrarar na conta do usuario que foi cadastrado com sucesso

@Cadastrojaexiste
Cenário: Fazer um cadastro, porém ele já estar cadastrado
	E  prencher o nome 
	E  prencher o email
	E  prencher a senha
	E  preencher a comfirmacao da senha
	E  prencher o primeiro nome
	E  preencher o sobrenome
	E  Preencher o telefone
	E  preencher o  país
	E  preencher a cidade
	E  preencher o endereço
	E  preencher o estado
	E  preencher o cep
	Quando clicar para aceitar os termos 
	E clicar em registrar
	Então terá que dar uma mensagem que de o usuario já existe 

