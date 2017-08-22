# How to launch the rest service
## On IntelliJ 
Run `nz.co.automation.rest.RestApplication`.

## On Commandline
Run `mvn spring-boot:run`.

# How to access h2-console 
* Set `spring.h2.console.enabled=true` .
* Console is accessible on url `localhost:8089/h2-console`.

# Docker Postgres Database schema
## Create user and database
* `create user automation;`
* `alter role automation with password 'automation';`
* `create database automation_db;`
* `grant connect on database gasmon_db to gasmon;`
* `revoke connect on database gasmon_db from public;`
## Create table, data and sequence for the id
* Create table dogs with id generated from sequence_dog_id table
    ```
    create sequence sequence_dog_id;
    create table dogs(
        id int not null default nextval('sequence_dog_id') primary key,
        name varchar(200) not null,
        age int not null
    );
    alter sequence sequence_dog_id OWNED BY dogs.id;
    ```
* Create data
    ```
    insert into dogs(name, age)
    values('Chihuahua', 2);
    
    insert into dogs(name, age)
        values('Phu Quoc', 3);
    ```
    
