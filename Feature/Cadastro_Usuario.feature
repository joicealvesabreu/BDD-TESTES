Feature: Realizar um  cadastro

Scenario: Fazer um cadastro com sucesso
Cenário: Cadastrar Perfil Auxiliar
Dado que eu esteja na tela de boas vindas
Quando eu acesso o menu Cadastrar Perfil

Given eu esteja na tela principal
When eu acessar o menu cadastrar perfil
And informar o nome 
And informar o e-mail 
And informar a senha 
And confirmar a senha 
And informar o nome 
And informae o sobrenome 
And informar o telefone 
And Selecionar o pais 
And informar a cidade 
And informar a rua 
And informar a cidade 
And informar o cep 
And selecionar o primeiro termo
And Aceitar o segundo termo
And o usuario e registrado no sistema
Then e vai estar ativo

