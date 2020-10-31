This simple project was created to show the usage of the Swagger Codegen Maven Plugin.

# Table of contents
* [Background](#background)
* [Features](#features)
* [Technologies](#technologies)
* [Setup](#setup)
* [Status](#status)
* [Contact](#contact)

#Background
##Introduction: API-driven development
Imagine that you are working on a project that aims to create two apps communicating with each other: one has a REST server implemented, receives requests and processes them, and the other one is a client for this server that sends requests to it. 
To save time, both applications are to be created at the same time by two different teams. Is this possible? Yes, using the so-called API-driven development. 

How does it work? 

Put simply, API-driven development (API-first approach) is the practice of designing and building APIs first, then creating the rest of an application around them (find out more: https://www.mertech.com/blog/api-driven-development).

First, an OpenAPI specification is created, e.g. in a yaml file, which is human-friendly and easy to understand.

Both teams receive the API definition and based on it, they can start simultaneously creating an implementation, both server and client.

##What is an OpenAPI?
OpenAPI Specification (an API description format for REST APIs) file allows you to describe your entire API, including:

   * Available endpoints (/users) and operations on each endpoint (GET /users, POST /users)
   * Operation parameters Input and output for each operation
   * Authentication methods
   * Contact information, license, terms of use and other information.

API specifications can be written i.e. in YAML, what makes it readable and easy to understand. 
More info: https://swagger.io/docs/specification/about/

##What can you do with an OpenAPI definition?
Once you have the OpenAPI specification file you can start to write the code manually, or save lots of time by generating it automatically. 

To do so, you can use:
* __online code generator__: https://editor.swagger.io/. Simply copy-paste your openAPI definition, choose the language, generate and download the code and copy-paste it into your project. But, keep in mind it is not the best idea – because if the API definition will change in the future (which happens quite often), it will be necessary for you to generate and implement the code again. 
* __offline CLI generator__:  Swagger Codegen CLI (https://github.com/swagger-api/swagger-codegen) or OpenAPI Generator CLI (https://github.com/OpenAPITools/openapi-generator)
* __OpenAPI plugin for IntelliJ__: https://www.jetbrains.com/help/idea/openapi.html
* __plugin__ to generate the code in the compile time: Swagger Codegen Maven Plugin (https://github.com/swagger-api/swagger-codegen/tree/master/modules/swagger-codegen-maven-plugin) or OpenAPI Generator Gradle Plugin (https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-gradle-plugin)

The generator will generate:
- Classes from the model.
- Interfaces and controllers.

The generator will not generate business logic - you have to implement it yourself, creating classes overwriting methods from the generated interfaces.

#Features
How I worked on this project:
1. I created and uploaded an OpenAPI definition: you can find it in "resources" directory.
2. I added Swagger Codegen Maven Plugin dependency and defined a task that generates the REST server classes in the compile time. 
3. I marked the generated code as sources root.
4. I run:

    `./gradlew clean build`

5. Having the API classes generated, I was able to start the implementation of the business logic:
I created a @Service class that implements the generated "ApiDelegate" interface and wrote the implementation for every endpoint method.
6. I created SwaggerConfig and SwaggerConfigUI classes to create a visual representation of my API. 
7. In addition, in the build.gradle file you can also see an exemplary task to generate the client side (commented).

##How to test it:
1. You can hit:

   `curl http://localhost:8080/albums`
   
   `curl http://localhost:8080/albums/1`
   
2. Or run the application:

    `./gradlew bootRun`
    
    and go to the `http://localhost:8080/swagger-ui.html` - here you can test the endpoints using Swagger UI. To do so, simply choose the endpoint, click "Try it now" modify the request and send it.

## Technologies
Used tools/ frameworks:

- Java 11
- Spring Boot
- Gradle
- Swagger Codegen Maven Plugin
- IntelliJ Ultimate Edition

## Setup
1. Compile: `./gradlew clean build`
2. Run: `./gradlew bootRun`

## Status
Project is: _finished_ 

## Contact
Created by [Marzena Kacprowicz](http://zrobtowinternecie.pl/) - feel free to contact me!
