package com.supermailer.mailscheduler.userAccount;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserAccount
{
    @JsonProperty("id")
    public String id;

    @JsonProperty("first_name")
    public String firstName;

    @JsonProperty("last_name")
    public String lastName;
    
    @JsonProperty("birthday")
    public String birthday;

    @JsonProperty("email")
    public String email;

    @JsonProperty("mobile_number")
    public String mobileNumber;

    @JsonProperty("address")
    public String address;

    @JsonProperty("notes")
    public String notes;

    public UserAccount(String id, String firstName, String lastName, String birthday, String email, String mobileNumber, String address, String notes)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.notes = notes;
    }

    public UserAccount(String firstName, String lastName, String birthday, String email, String mobileNumber, String address, String notes)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.notes = notes;
    }
}
