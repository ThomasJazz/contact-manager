package com.supermailer.mailscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailschedulerApplication {

	// Project can be ran with
	// or you can create a jar and then execute it:
	// > ./mvnw clean package
	// > java -jar target/mailscheduler-0.0.1-SNAPSHOT.jar
	// 
	// Target path is defined in pom.xml: 
	// 		<artifactId>mailscheduler</artifactId>
	// 		<version>0.0.1-SNAPSHOT</version>
	public static void main(String[] args) 
	{
		SpringApplication.run(MailschedulerApplication.class, args);
		System.out.println("Web server launched successfully!");
	}
}
