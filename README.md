# API Rest em JAVA com DB Postgres e Deploy

## Stacks

* Linux
* Git
* Java 8
* Docker
* IntelliJ Community
* Heroku CLI

## DataBase

### Postgres

* [Postgres Docker Hub](https://hub.docker.com/_/postgres)

## O deploy dessa API Rest foi feita no Heroku e pode ser acessada nesses endeços

```
http://cities-api-java.herokuapp.com/countries

http://cities-api-java.herokuapp.com/cities

http://cities-api-java.herokuapp.com/states
```
Pode também usar variações de busca, como paginação, quantidade e ordem

```
http://cities-api-java.herokuapp.com/cities?page=10&size=20&sort=id,asc
```
## Para instalar em LocalHost
### Clone o Repositório ou faça um fork

`git clone https://github.com/4lexRossi/cities-api.git`

### Passos Para rodar
esse comnado vai criar um DB PostgreSQL direto em um container(você tem que ter o Docker instalado)

```shell script
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

## Populate
### Esses foi a source usado para popular o DB

* [data](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

### Entre na pasta que você Extraiu os arquivos e execute os comandos abaixo

```shell script
cd ~ - /sql-paises-estados-cidades/PostgreSQL

docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

psql -h localhost -U postgres_user_city cities

CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```

* [Postgres Earth distance](https://www.postgresql.org/docs/current/earthdistance.html)
* [earthdistance--1.0--1.1.sql](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.0--1.1.sql)
* [OPERATOR <@>](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.1.sql)
* [postgrescheatsheet](https://postgrescheatsheet.com/#/tables)
* [datatype-geometric](https://www.postgresql.org/docs/current/datatype-geometric.html)

### Access

```shell script
docker exec -it cities-db /bin/bash

psql -U postgres_user_city cities
```

### Query Earth Distance

Point
```roomsql
select ((select lat_lon from cidade where id = 4929) <@> (select lat_lon from cidade where id=5254)) as distance;
```

Cube
```roomsql
select earth_distance(
    ll_to_earth(-21.95840072631836,-47.98820114135742), 
    ll_to_earth(-22.01740074157715,-47.88600158691406)
) as distance;
```

### Pode testar os Métodos pelo Postman, Insomnia ...

[Postman](https://www.postman.com/)

## Spring Boot

* [spring.io/](https://start.spring.io/)

+ Java 8
+ Gradle Project
+ Jar
+ Spring Web
+ Spring Data JPA
+ PostgreSQL Driver

### Spring Data

* [jpa.query-methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)

### Properties

* [appendix-application-properties](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html)
* [jdbc-database-connectio](https://www.codejava.net/java-se/jdbc/jdbc-database-connection-url-for-common-databases)

### Types

* [JsonTypes](https://github.com/vladmihalcea/hibernate-types)
* [UserType](https://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/usertype/UserType.html)

## Heroku

* [DevCenter](https://devcenter.heroku.com/articles/getting-started-with-gradle-on-heroku)

## Code Quality

### PMD

+ https://pmd.github.io/pmd-6.8.0/index.html

### Checkstyle

+ https://checkstyle.org/

+ https://checkstyle.org/google_style.html

+ http://google.github.io/styleguide/javaguide.html

```shell script
wget https://raw.githubusercontent.com/checkstyle/checkstyle/master/src/main/resources/google_checks.xml
```

<h1 align="center">Oi quer ser meu Amigo, clica ai e conecta
</h1>
<p align="center">
  <a href="https://www.linkedin.com/in/4lex/">
    <img src="https://avatars3.githubusercontent.com/u/62000504?s=400&u=9077ec8b32016a8accbb59dfc8e6d217b7b1b468&v=4" title="Alex Rossi" width="100" height="100">
  </a>x