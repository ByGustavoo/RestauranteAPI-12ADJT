<div align="center"> <br> 
  <img align="center" alt="guru-java" height="150" width="150" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" />
</div> 

<br> 

<div align="center">
  Turma 12ADJT – Projeto desenvolvido na pós-graduação em Arquitetura e Desenvolvimento em Java da FIAP. O objetivo deste projeto é criar um sistema robusto que permita aos restaurantes gerenciar suas operações de forma eficiente, enquanto os clientes poderão consultar informações, deixar avaliações e realizar pedidos online.
</div> 

 <br> <br> 

## 🧰 Ferramentas Utilizadas

* 🛠️ Gradle

* ☕️ Java 21

* 🐘 Postgres 

* 🟢 Spring Boot 4.0.5

<br> 

## ⚙️ Configurações Disponíveis

🔹`BootRun - DEV`, executa a API no perfil de desenvolvimento, ideal para desenvolvimento local, criação de novas funcionalidades e realização de testes durante a implementação.

<br> 

🔹 `BootRun - PROD`, executa a API utilizando o perfil de produção localmente, permitindo simular o comportamento da aplicação em ambiente de produção.

<br> 

🔹`Clean Build - [Without Tests]`, realiza o processo de build da aplicação sem executar os testes automatizados, limpando arquivos anteriores e recompilando o projeto de forma mais rápida. 

<br> 

## 🛠️ Desenvolvimento 

Para o ambiente de desenvolvimento, o projeto disponibiliza o arquivo `docker-compose-postgres.yml`, já configurado com todas as variáveis necessárias para conexão com o banco de dados. 

Para iniciar o serviço do PostgreSQL, execute no terminal: 

```bash
docker compose -f docker-compose-postgres.yml up -d
```

Em seguida, execute a aplicação utilizando a opção `BootRun - DEV`. Dessa forma, a API será conectada automaticamente ao banco de dados configurado no Docker Compose, facilitando a execução do projeto em ambiente local e ficando disponível na porta `9017`.

<br> 

## 🚀 Produção

Para execução em ambiente de produção, o projeto disponibiliza o arquivo `docker-compose-restauranteapi.yml`. Antes de iniciar a aplicação, é necessário configurar o arquivo `.env` com as variáveis de conexão do banco de dados, conforme o ambiente desejado:

```bash
# DATABASE_NAME
$ Exemplo: postgres

# DATABASE_USER
$ Exemplo: postgres

# DATABASE_PASSWORD
$ Exemplo: postgres@2026
```

Após configuraro arquivo `.env` com as variáveis de conexão do banco de dados, execute no terminal:

```bash
docker compose -f docker-compose-restauranteapi.yml up -d
```

Dessa forma, a API será iniciada utilizando as variáveis definidas no arquivo `.env` e ficará disponível na porta `9027`.

<br> 

## 📑 Swagger

Para acessar a documentação da API, inicie a aplicação utilizando a opção `BootRun - DEV` e acesse o link abaixo no seu navegador.

```bash
# URL para acessar a documentação da API 
$ http://localhost:9017/RestauranteAPI/swagger-ui/index.html
```

<br> 

## ⚠️ Observação

Recomenda-se utilizar o IntelliJ IDEA como IDE para este projeto, pois ele já possui configurações prontas para execução e build, como `BootRun - DEV`, `BootRun - PROD` e `Clean Build - [Without Tests]`. Dessa forma, o uso do IntelliJ proporciona uma experiência mais prática e otimizada no desenvolvimento.
