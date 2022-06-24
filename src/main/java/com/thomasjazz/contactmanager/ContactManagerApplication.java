package com.thomasjazz.contactmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@AutoConfiguration
public class ContactManagerApplication {

	// Project can be ran with
	// or you can create a jar and then execute it:
	// > ./mvnw clean package
	// > java -jar target/contactmanager-0.0.1-SNAPSHOT.jar
	// 
	// Target path is defined in pom.xml: 
	// 		<artifactId>contactmanager</artifactId>
	// 		<version>0.0.1-SNAPSHOT</version>
	public static void main(String[] args) 
	{
		SpringApplication.run(ContactManagerApplication.class, args);
		System.out.println("Web server launched successfully!");
	}
}
