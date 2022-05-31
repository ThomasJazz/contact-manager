package com.supermailer.mailscheduler.model;
import java.lang.reflect.*;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class UserAccount extends Card
{
    @JsonProperty("user_id")
    public String userId;

    public UserAccount(String userId, 
        String firstName, 
        String lastName, 
        String birthday, 
        String emailAddress, 
        String mobileNumber, 
        String address, 
        String notes
    )
    {
        super(firstName, lastName, birthday, emailAddress, mobileNumber, address, notes);
        this.userId = userId;
    }

    public UserAccount(String firstName, String lastName, String birthday, String emailAddress, String mobileNumber, String address, String notes)
    {
        super(firstName, lastName, birthday, emailAddress, mobileNumber, address, notes);
    }

    public static Type getArrayListToken()
    {
        return new TypeToken<ArrayList<UserAccount>>(){}.getType();
    }
}
