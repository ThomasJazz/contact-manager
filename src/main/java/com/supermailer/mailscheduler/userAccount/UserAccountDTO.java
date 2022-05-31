package com.supermailer.mailscheduler.userAccount;
import java.lang.reflect.*;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class UserAccountDTO
{
    @JsonProperty("id")
    public String id;

    @JsonProperty("first_name")
    public String firstName;

    @JsonProperty("last_name")
    public String lastName;
    
    @JsonProperty("birthday")
    public String birthday;

    @JsonProperty("email_address")
    public String email_address;

    @JsonProperty("mobile_number")
    public String mobileNumber;

    @JsonProperty("address")
    public String address;

    @JsonProperty("notes")
    public String notes;

    public UserAccountDTO(){}

    public UserAccountDTO(String id, String firstName, String lastName, String birthday, String email_address, String mobileNumber, String address, String notes)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email_address = email_address;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.notes = notes;
    }

    public UserAccountDTO(String firstName, String lastName, String birthday, String email_address, String mobileNumber, String address, String notes)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email_address = email_address;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.notes = notes;
    }

    public static Type getArrayListToken()
    {
        return new TypeToken<ArrayList<UserAccountDTO>>(){}.getType();
    }
}
