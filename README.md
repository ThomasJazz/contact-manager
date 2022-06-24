# contact-manager
*NOTE*
- *I am using this README as a notebook as I learn new things so a lot of it is not directly related to this project*
- *This is not actually intended to be used by anyone; I just created this to learn the stack*

## Project Objectives
- The goal of this project is to gain experience building API's with a Java stack
- Frameworks & Tools
    - Java 
        - Java Spring Boot
        - For interacting with DB's in Java, I will be looking into
            - [JDBC and JPA](https://stackoverflow.com/questions/11881548/jpa-or-jdbc-how-are-they-different)
            - [Hibernate](https://hibernate.org/)
            - [ORM](https://en.wikipedia.org/wiki/Object%E2%80%93relational_mapping) in general
    - PostgresSQL
        - Set up a PostgresSQL database on my personal computer
        - Create some basic tables and populate them via my *Super Mailer* API
        - pgAdmin
    - Angular (Maybe)
    - React (Maybe)
    
## What does the Super Mailer API do?
- Allows users to manage contact lists
- Users can get, add, update contacts

# Endpoints
- `/add-user` *POST*
    - Insert record to `user_account` DB table
    - Return created record in `UserAccount` object JSON
    - User accounts belong to the people that manage the email distribution lists
- `/add-contact` *POST*
    - Insert record to `contact` DB table
    - `Contact`s always have `UserAccount`

# Stack Notes

## Spring Boot
- Spring Boot offers some cool features that I've had to implement in my own custom `dotnet` libraries

- Not sure how to best organize files for related classes/objects... 
    - Should API endpoint groups have their own folders for the related `@RestController`'s?
    - Should utility libraries made for the project be in the library folder within the project? Or within the root directory?
    - (Will look up these questions soon)

- Auto-JSON serialization for `@RestController` function returns is very nice

- Deserializing from JSON -> CustomObjectType seems more difficult/not as built int?
    - I think there must be an easy way to do this since they auto-serialize returns, but as of 5/30 I have not found a 1-line solution for this (looking for `JsonConvert.Deserialize` equivalent)
    - Which JSON package is used most? Every time I look on stack overflow it's using either `org.json`, `com.fasterxml.jackson.core.json`, or `com.google.gson`
    - Found it: `ArrayList<UserAccount> accounts = gson.fromJson(json, new TypeToken<ArrayList<UserAccount>>(){}.getType());`
        - Very tilted that I can't have a global deserialization function without using a `TypeToken` (because the class I put that function in would need to know the type of object it's passed exists i think)

- String interpolation doesn't exist in Java (need to use "string" + stringVar)
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

- Target path is defined in pom.xml
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

## Apache Kafka
- [vs. Azure EventHub](https://docs.microsoft.com/en-us/azure/event-hubs/event-hubs-for-kafka-ecosystem-overview)
    - "the reality is that Apache Kafka doesn't implement, for instance, the competing-consumer queue pattern, doesn't have support for publish-subscribe at a level that allows subscribers access to the incoming messages based on server-evaluated rules other than plain offsets, and it has no facilities to track the lifecycle of a job initiated by a message or sidelining faulty messages into a dead-letter queue, all of which are foundational for many enterprise messaging scenarios."

# Current Questions
- Which class should have 