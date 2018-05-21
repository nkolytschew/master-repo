# master-repo
For my Spring Cloud Config Server Example

## Intro
This is an overall example of the transition from a monolithic application to a micro-service architecture using 
* Spring Cloud Config Server
* Service Discovery
* Circuit Breaker

The repository has the following folders
* [Docs](/docs) with additional documentation and images
* [Configs](/configs) having the configuration for our Config-Server and corresponding applications
* [Base](/00-base) starting with our example
* [Config-Server](/01-config-server) consists of the first iteration to transform our monolithic base to a micro-service architecture using config-server
* [Service-Discovery]((/02-service-discovery))

## Base
Please consider [Monolith base](/00-base).

Starting with a plain web application. The keep the example simple, we won't focus on a frontend and only print JSON responses. 

Our simple application consists of two services, reading user inputs, transform them and create database entries.

![Monolithic architecture overview](docs/images/Monolithic%20Architecture.png "Architecture Overview")

As shown in the image, we have a controller as a single entry point, validating user inputs, and sending them to our service. The RegistrationService then has to decide, if we have to create new Registration, User, or something else and communicates with the database. 
Last, the response will be send back to the Controller, which transforms it to a JSON representation and sends it to the browser.

Further information can be found [here](/00-base/registration-monolith/README.md).

