#Inicio dos testes de cliente especial e comum
@tag
Feature: Cliente faz saque de dinheiro Como um cliente, eu gostaria de sacar dinheiro em caixa eletrônico,
para que eu não tenha que esperar numa fila de banco.
  I want to use this template for my feature file

#Cenário de cliente especial
  @tag1
  Scenario: Cliente especial com saldo negativo
    Given Um cliente especial com saldo atual de -200 reais
    When for solicitado um saque no valor de 100 reais
    Then deve efetuar o saque e atualizar o saldo da conta para -300 reais
    
#Cenário de cliente comum
  @tag2
  Scenario Outline: Cliente comum com saldo negativo
    Given Um cliente comum com saldo atual de -300 reais
    When solicitar um saque de 200 reais
    Then Não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente

   