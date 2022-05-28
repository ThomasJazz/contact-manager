// Created by following https://spring.io/guides/gs/rest-service/#scratch
package com.supermailer.mailscheduler;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Resource Controller
// GreetingController handles GET requests for /greeting endpoint by returning a new instance of the Greeting class
@RestController
public class GreetingController 
{
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    // HTTP requests are handled by a controller
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name)
    // @RequestParam binds the value of the query string parameter name into the 'name' parameter of the greeting()
    // If the 'name' parameter is absent in the request, the 'defaultValue' of 'World' is used
    // NOTE: I believe this is basically spring boots version of Function bindings in Azure Functions
    {
        // Spring converts this response object to JSON for me
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
