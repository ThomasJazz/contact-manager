# super-mailer
*NOTE*
- *I am using this README as a notebook as I learn new things so a lot of it is not directly related to this project*
- *This is not actually intended to be used by anyone; I just created this to learn the stack*

## Project Objectives
- The goal of this project is to gain experience building API's with a Java stack
- Tools used:
    - Java Spring Boot
    - JDBC
    - PostgresSQL
        - Set up a PostgresSQL database on my personal computer
        - Create some basic tables and populate them via my *Super Mailer* API
    - pgAdmin
    

## What does the Super Mailer API do?
- Allows users to manage small e-mail distribution lists
- Users can schedule e-mails to be sent out to their distribution lists

# Stack Notes

## Spring Boot & Maven
- Spring Boot offers sooooo many features that I've had to implement in my own custom `dotnet` libraries
- Not sure how to
- Auto-JSON serialization for returns is very nice, but Deserializing from JSON -> CustomObjectType seems more difficult/not as built int?
    - I think there must be an easy way to do this since they auto-serialize returns, but as of 5/30 I have not found a 1-line solution for this (looking for `JsonConvert.Deserialize` equivalent)
- Java String interpolation sucks (it doesn't exist)
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

## Postgres
- [Initial setup guide](https://www.microfocus.com/documentation/idol/IDOL_12_0/MediaServer/Guides/html/English/Content/Getting_Started/Configure/_TRN_Set_up_PostgreSQL.htm) I followed

### Launching
- Start **Apache** Web Server
    > net start
    
- Stop **Apache** Web Server (Run cmd/other terminal as administrator)
    > TASKKILL /F /IM httpd.exe /T

- Start Postgres server (Must do this before any of the below commands will work):
    > pg_ctl -D "C:\Program Files\PostgreSQL\14\data" start

- Open command-line tool:
    > psql -U postgres

- Stop Postgres server:
    > pg_ctl -D "C:\Program Files\PostgreSQL\14\data" stop

### Meta-commands
- List DB's and some meta info
    > \list