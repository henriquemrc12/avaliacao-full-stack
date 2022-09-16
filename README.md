# Teste Full-stack API + Front-end

## Pré-requisitos
Ter as seguintes tecnologias instaladas
- Node v14 ou superior
- Angular 14
- JDK 11
- Apache Maven 3

## Rodar o projeto

Para rodar a API. Entre na pasta `api` e rode os seguinte comandos
```bash
# Faz o Build da API
mvn clean install
#Inicia a API
java -jar target/api-0.0.1-SNAPSHOT.jar
```

Para rodar o Front-end. Entre na pasta `front-end` e rode os seguinte comandos
```bash
# Instala os pacotes do projeto
npm install
#Inicia o Front-end
ng serve
```
## Local que os serviços estarão rodando 
- API: http://localhost:8080
- Front-end: http://localhost:4200