# Implantação do JUnit no projeto
## Descrição
Abaixo, estão alguns testes utilizando JUnit 1.2.5 juntamente do cucumber 1.2.5, sendo utilizado os cenários do arquivo conta_bdd.feature

## Primeiro caso:
Segundo cenário definido como outline (Ele existe, mas não será executada nos testes).

### Teste 1
Variáveis da classe runner dryRun e strict definidas como false e true respectivamente, com o teste passando no primeiro cenário, temos este resultado:

![image](https://user-images.githubusercontent.com/10741915/202819735-f8923998-2613-4250-ab1c-d134864fe4e0.png)

### Teste 2
Variáveis da classe runner dryRun e strict definidas como false e true respectivamente, com o teste falhando no primeiro cenário, temos este resultado:
 
![image](https://user-images.githubusercontent.com/10741915/202820261-761749e1-307f-4693-9286-86a814dc7458.png)

### Teste 3
Variáveis da classe runner dryRun e strict definidas como true e false respectivamente, com o teste passando no primeiro cenário, temos este resultado:
 
![image](https://user-images.githubusercontent.com/10741915/202820515-bf561b5d-8b7a-41ff-9e14-1fa340ad2739.png)

### Teste 4
Variáveis da classe runner dryRun e strict definidas como true e false respectivamente, com o teste falhando no primeiro cenário, temos este resultado:

![image](https://user-images.githubusercontent.com/10741915/202820610-deeb9557-e534-4f6e-97aa-3d86caacd05d.png)

## Observações do primeiro caso
Nesse primeiro caso, pode se observar que, ao mudar dryRun para true e trocar strict para false, o teste deixou de ser executado em cada passo, fazendo com que o cenário passe no teste sem necessariamente ser testado os métodos. Já com o dryRun definido como false e o strict definido como true, cada passo do cenário estava sendo testado, e se algo desse errado em um dos passos, o teste desse cenário seria encerrado e seria indicado que o teste não passou. Além disso, como o segundo cenário está definido como outline, o mesmo não está sendo testado.

## Segundo caso:
Segundo cenário não definido como outline (Fazendo parte da execução de testes atual).

### Teste 5
Variáveis da classe runner dryRun e strict definidas como false e true respectivamente, com o teste passando no primeiro cenário e no segundo cenário, temos estes resultado:
 
![image](https://user-images.githubusercontent.com/10741915/202820952-2748aa33-d910-479b-ab62-2d1fe5183be5.png)

### Teste 6
Variáveis da classe runner dryRun e strict definidas como false e true respectivamente, com o teste falhando no primeiro cenário e passando no segundo cenário, temos estes resultado:
 
![image](https://user-images.githubusercontent.com/10741915/202820999-11efcbe4-ea6a-45f4-b75d-d6bb9bcd2b2a.png)

### Teste 7
Variáveis da classe runner dryRun e strict definidas como false e true respectivamente, com o teste falhando no primeiro cenário e no segundo cenário, temos estes resultados:
 
![image](https://user-images.githubusercontent.com/10741915/202821156-3d20c676-a099-426b-b84d-8fd70105619b.png)

### Teste 8
Variáveis da classe runner dryRun e strict definidas como false e true respectivamente, com o teste passando no primeiro cenário e falhando no segundo cenário, temos estes resultados:
 
![image](https://user-images.githubusercontent.com/10741915/202821334-62f1e758-4a52-4f8a-a6b9-cbb72dac6933.png)
  
### Teste 9
Variáveis da classe runner dryRun e strict definidas como true e false respectivamente, com o teste passando no primeiro cenário e no segundo cenário, temos estes resultados:
 
![image](https://user-images.githubusercontent.com/10741915/202822969-a16c31fd-e87a-4f0d-9857-8165658471b6.png)

### Teste 10
Variáveis da classe runner dryRun e strict definidas como true e false respectivamente, com o teste falhando no primeiro cenário e no segundo cenário, temos estes resultados:
 
![image](https://user-images.githubusercontent.com/10741915/202823034-28e6d477-cc37-4aa4-aa62-3e2cc608143a.png)

### Teste 11
Variáveis da classe runner dryRun e strict definidas como true e false respectivamente, com o teste passando no primeiro cenário e falhando no segundo cenário, temos estes resultados:

![image](https://user-images.githubusercontent.com/10741915/202823473-a9204ab9-faba-4c45-8fc0-ce39067f3b63.png)

### Teste 12
Variáveis da classe runner dryRun e strict definidas como true e false respectivamente, com o teste falhando no primeiro cenário e passando no segundo cenário, temos estes resultados:

![image](https://user-images.githubusercontent.com/10741915/202823473-a9204ab9-faba-4c45-8fc0-ce39067f3b63.png)


## Observações do segundo caso
Nesse segundo caso, pode se observar que, ao mudar dryRun para true e trocar strict para false, o teste deixou de ser executado em cada passo, fazendo com que os cenários passassem no teste sem necessariamente ser testados os métodos. Já com o dryRun definido como false e o strict definido como true, cada passo dos cenários estavam sendo testados, e se algo desse errado em um dos passos do cenário específico, o teste desse cenário seria encerrado e seria indicado que o teste não passou.

# Extra
Ao utilizar o dryRun e o strict como true, em todos os casos, houveram os mesmos resultados de quando foi utilizado o dryRun como true e o strict false. Os testes passaram independente do que havia nos passos do cenário.

# Conclusões
A variável strict definia que era necessário que todos os passos passassem para que o teste passasse, já a variável dryRun apenas verificava se o cenário existia, não necessariamente a lógica dele, passando o cenário sem testar os passos.
