package com.supermailer.mailscheduler;

import java.util.ArrayList;
import java.util.List;
import java.lang.Object;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.catalina.User;
import org.json.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.supermailer.library.*;
import com.supermailer.mailscheduler.model.UserAccount;


@SuppressWarnings("unchecked")
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

	public static <T> T convertJsonToObject(String json, Class<T> type) throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();

        T obj = mapper.readValue(json, type);

        return obj;
    }
}
