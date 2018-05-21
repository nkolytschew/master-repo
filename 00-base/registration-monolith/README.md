# Registration Monolith

Please keep in mind, that this is a simple example to transition from a monolithic architecture to a micro-service architecture with Spring Boot/Cloud and Netflix. 
The example provided ignores some coding practices. Also we are not focusing on creating proper normalized data models, avoid writing tests and ignoring 'Spring Security' and 'Spring Data Auditing'.

![Overview](../../docs/images/Monolithic%20Architecture.png)

## Technology
* Spring Boot Web
* Spring Boot Data JPA
* In-Memory Database for simplification
* Maven

## Drawbacks
* problematic to scale this application within the cloud.
* more complicated to reuse specific components

## Advantage
* easy to begin
* easy to monitor
* easy to test
* easy to debug

## Profiles
This application supports different profiles
* [default profile](/src/main/resources/application.properties)
* [cloud profile](/src/main/resources/application-cloud.properties)

The default, or development profile set the properties for developing the application on your local machine, using the default server port (8080) and a in memory Database. 

The cloud profile will be used, after deployment to a cloud environment using a different port and changing from an in-memory to a _real_ database.