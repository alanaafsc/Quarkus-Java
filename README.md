# Quarkus - Project 1

### Project used to make CRUD with Rest API, with any entity, using H2 memory database

<aside>
🔀 Quarkus is a stack made to run on kubernetes, built on top of several other technologies. It can run on both HotSpot and GraalVM, created from the best java libraries and java standards.

</aside>

- Call our REST services → **Postman** (Client)
- **Entity** was a class called Fruit, with two attributes → name and quantity

CRUD

A sigla surgiu a partir das 4 operações básicas de um banco de dados, Insert, Select, Update e Delete.

Então a sigla CRUD é um acrônimo, de quatro operações básicas, são elas:

C: Create – Criar um novo registro.

R: Read – Ler um registro, ou uma lista de registros.

U: Update – Atualizar um registro.

D: Delete – Excluir um registro.

API Rest

Uma interface de programação de aplicação (API) define as regras que você precisa seguir para se comunicar com outros sistemas de software. Os desenvolvedores expõem ou criam APIs para que outras aplicações possam se comunicar com suas aplicações programaticamente. A API RESTful é uma interface que dois sistemas de computador usam para trocar informações de forma segura pela internet. A maioria das aplicações de negócios precisa se comunicar com outras aplicações internas e de terceiros para executar várias tarefas.

H2 Database

H2 é um sistema de gerenciamento de banco de dados relacional escrito em Java. Ele pode ser incorporado em aplicativos Java ou executado no modo cliente-servidor. Portanto, H2 é um mecanismo de ***banco de dados*** SQL que está escrito em Java™ que implementa a API JDBC.

Postman

O **Postman** é um API Client que facilita aos desenvolvedores criar, compartilhar, testar e documentar APIs. Isso é feito, permitindo aos usuários criar e salvar solicitações HTTP e HTTPs simples e complexas, bem como ler suas respostas.

---

## ****Bootstrapping****

In the project, the Java 11 version and the Maven build tool were used. The Maven plugin currently offers more features, so we will use it. 

- Group: projeto.alana
- Artifact: code-with-quarkus-3
- Build tool: Maven
- Version: 1.0.0-SNAPSHOT
- Java Version: 11

---

## Extensions

Todas as extensões foram adicionadas através do comando maven abaixo: 

```java
./mvnw quarkus:add-extensions -Dextensions="nome-da-extensao"
```

- RESTEasy Classic → Para criação de aplicações REST
- Hibernate ORM with Panache → O Hibernate é um framework [ORM (Mapeamento Objeto](https://stackoverflow.com/questions/1279613/what-is-an-orm-how-does-it-work-and-how-should-i-use-one) Relacional[)](https://stackoverflow.com/questions/1279613/what-is-an-orm-how-does-it-work-and-how-should-i-use-one), que tem como objetivo, facilitar o mapeamento das tabelas, atributos e relacionamentos de um banco de dados para uma classe java. O objetivo do Panache é simplificar a camada de persistência, principalmente das operações triviais.
- JDBC Driver - H2 → quarkus-jdbc-h2, utilizado para implementar o banco de dados do tipo H2. H2 é um banco de dados JAVA. Podemos interagir com esse banco de dados usando JDBC.
- RESTEasy Classic Jackson → extensão JSON suportada pelo RESTEasy Classic.

---

---

# Quarkus - Project 1.1

Após a construção do projeto 1, foram feitas modificações no projeto a fim de utilizar o Docker para rodar a aplicação. Com isso, utilizou-se do Docker Compose, que é um orquestrador de conteiners. Nesse arquivo Compose, descrevemos a infraestrutura como código e como ela vai se comportar ao ser iniciado. No arquivo do projeto, a aplicação Java depende do banco de dados para rodar a aplicação. Tanto a aplicação como o banco de dados então sendo utilizados como containers e estão se comunicando entre eles seguindo a configuração descrita no docker-compose.

As seguintes modificações foram feitas:

- Mudança do banco de dados H2 para PostgreSQL
- Criação do arquivo docker-compose.yml
- Modificação do arquivo applications.properties, para utilizarmos o PostgreSQL
- Adição de novas extensões

---

## New Extensions

- `quarkus-jdbc-postgresql` → PostgreSQL JDBC Driver permite que programas Java se conectem a um banco de dados PostgreSQL usando código Java padrão independente de banco de dados.
- Container Image Docker → Constrói imagens de container da aplicação usando Docker

---

## Building and Running

O Quarkus oferece uma escolha de 2 modos de execução. Você pode executar como um binário nativo ou como bytecode em uma JVM. Para construir o pacote da aplicação, foi utilizado o modo nativo: 

```java
./mvnw package -Pnative  -DskipTests
```

Com a utilização do docker-compose, o comando acima é inicializado no próprio arquivo. Portanto, é utilizado: 

```java
docker-compose up -d
```

Assim, tem-se o container do projeto rodando, com dois containers: da aplicação e do banco de dados, que se comunicam. 

---

---

# **code-with-quarkus Project**

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: [https://quarkus.io/](https://quarkus.io/) .

## **Running the application in dev mode**

You can run your application in dev mode that enables live coding using:

```
./mvnw compile quarkus:dev

```

> NOTE: Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.
> 

## **Packaging and running the application**

The application can be packaged using:

```
./mvnw package

```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory. Be aware that it’s not an *über-jar* as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an *über-jar*, execute the following command:

```
./mvnw package -Dquarkus.package.type=uber-jar

```

The application, packaged as an *über-jar*, is now runnable using `java -jar target/*-runner.jar`.

## **Creating a native executable**

You can create a native executable using:

```
./mvnw package -Pnative

```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```
./mvnw package -Pnative -Dquarkus.native.container-build=true

```

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult [https://quarkus.io/guides/maven-tooling](https://quarkus.io/guides/maven-tooling).

## **Related Guides**

- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing JAX-RS and more

## **Provided Code**

### **RESTEasy JAX-RS**

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
