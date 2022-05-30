package com.supermailer.mailscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.*;
import com.google.gson.Gson;

import com.supermailer.mailscheduler.userAccount.UserAccount;

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

		String idJson = "[{\"id\":3}]";
		//JSONArray array = new JSONArray();
		//JSONObject obj = new JSONObject();
		//obj.put("id", 3);
		//array.put(obj);

		UserAccount account = new Gson().fromJson(idJson, UserAccount.class);

		System.out.println("UserAccount ID: " + account.id);
	}

	public static <T> T convertJsonToObject(String json, Class<T> type) throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();

        T obj = mapper.readValue(json, type);

        return obj;
    }
}
