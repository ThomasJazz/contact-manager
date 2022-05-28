# super-mailer
***NOTE:** I am using this README as a notebook as I learn new things so a lot of it is not directly related to this project*

## Project Objectives
- The goal of this project is to gain experience building API's with a Java stack. Specifically, I want to learn how to use these tools/frameworks/languages
    - Java
    - Java Spring Boot
    - PostgresSQL
        - Set up a PostgresSQL database on my personal computer
        - Create some basic tables and populate them via my *Super Mailer* API

## What does the Super Mailer API do?
- Allows users to manage small e-mail distribution lists
- Users can schedule e-mails to be sent out to their distribution lists
- This is not actually intended to be used by anyone; I just created this to learn the stack

# Notes
## Spring Boot & Maven
- Spring Boot offers sooooo many features that I've had to implement in my own custom `dotnet` libraries
- Auto-JSON serialization is very nice
- The project build/WebServer launch appears to be magnitudes faster than building and running an Azure Functions host 
    - Could be partially due to my personal computer being much faster than my work laptop

### REST End Points
- Resource Representation Class
- Resource Controller

### Building the Project
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

## Postgres commands to remember
- Open command-line tool:
    `psql -U userName`

- Start Postgres server:
    `pg_ctl -D "C:\Program Files\PostgreSQL\14\data" start`

- Stop Postgres server:
    `pg_ctl -D "C:\Program Files\PostgreSQL\14\data" stop`

- Stop Apache web server:
    `TASKKILL /F /IM httpd.exe /T`
    - *Note*: After doing this, you should be able to manually start the process again via the Services console, or via the 'net start' command