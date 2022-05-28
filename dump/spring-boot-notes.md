## General Notes
- Spring Boot offers sooooo many features that we had to implement in our own `dotnet` libraries
- Auto-JSON serialization is very nice


## REST End Point
- Resource Representation Class
- Resource Controller

## Building the Project
- Project can be ran with
    - > ./mvnw spring-boot:run
- or you can create a jar and then execute it:
    - > ./mvnw clean package
    - > java -jar target/mailscheduler-0.0.1-SNAPSHOT.jar

- Target path is defined in pom.xml: 
    ```xml
    <artifactId>mailscheduler</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    ```