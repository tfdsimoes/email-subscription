## Introduction

These is a solution for the challenge of adidas.

Note the instructions are made for linux system.

## Projects in repository

* public-service 

These service is responsible to receive request from the frontend and redirect to subscription.

These service is running in the port 8081 and can be accessed by outside by anyone.

* subscription-service 

These service will receive request from the public-service and register the new subscription to be registered in the database. Also will communicate with email-service to send an email.

These service is running in port 8082 and is only accessed by other services, is in a private network. Also these endpoint is protected with basic auth username, adidas, and password, adidas.

* email-service 

These service is responsible to send emails to users, is missing the part of sending the email, it communicates with subscription-service using kafka, producer - consumer, to respect the SLA;

These service is running in port 8083, there is no endpoints.

## Requirements to Run

Before running check if you have ```docker-compose``` and ```docker``` installed.

## Tests
Not implemented

## Building and Running

There is two ways to run the program

### Script
There is script in the root of the project that will compile, deploy the docker images and start docker-compose. To run:
```bash
$ sh build_run.sh
```

### Manual way

Go to each module of the project, public-service, subscription-service and email-service, and run:
```bash
$ ./mvnw clean package
```

These will compile and create docker images in the system

Then to run the project just run the following command in the root of the same:

```bash
$ docker-compose -f docker-compose.yml up
```

## Endpoints

Documentation about endpoints can be found in yml at the folder api-documentation, the documentation is done in swagger.

Also to help can be found a [Postman](https://www.getpostman.com/) collection in the root of the project to help to use the project.

## Libs

The project use the following libs:

| Lib | Usage |
| --- | --- |
| spring-boot-starter-web| Starter for building web, including RESTful, applications using Spring MVC |
| spring-boot-starter-test | Starter for testing Spring Boot applications with libraries including JUnit, Hamcrest and Mockito (no tests implemented) |
| lombok | Automatic Resource Management, automatic generation of getters, setters, equals, hashCode and toString, ... |
| jackson-databind| High-performance JSON processor (parser, generator) |
| spring-kafka | Responsible for communication between services using queue (subscription - email) |
| spring-boot-starter-security | Libs of spring to implement security to the endpoints |
| spring-security-test | Spring boot libs for testing security |
| h2 | In memory database that allows to store the subscription |
| spring-boot-starter-data-jpa | Lib for access and manipulate databases using hibernate |
| spring feign | Feign makes writing web service clients easier with pluggable annotation support |
| mapstruct | Code generator that greatly simplifies the implementation of mappings between Java bean types based |
| docker-maven-plugin | A Maven plugin for building and pushing Docker images |


## CI/CD Pipeline Proposal
 [CI/CD Pipeline Proposal](./ci_cd_proposal.md)
