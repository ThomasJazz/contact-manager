package com.supermailer.mailscheduler.model;
import java.lang.reflect.*;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class UserAccount extends Card
{
    // @JsonProperty("user_account_id")
    // public String userAccountId;

    public UserAccount(String userAccountId, 
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
        this.userAccountId = userAccountId;
    }

    public UserAccount(String firstName, String lastName, String birthday, String emailAddress, String mobileNumber, String address, String notes)
    {
        super(firstName, lastName, birthday, emailAddress, mobileNumber, address, notes);
        this.userAccountId = "";
    }

    public static Type getArrayListToken()
    {
        return new TypeToken<ArrayList<UserAccount>>(){}.getType();
    }
}
