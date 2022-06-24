package com.thomasjazz.contactmanager.entity;
import com.fasterxml.jackson.annotation.*;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;


public abstract class Card 
{
    @JsonProperty("first_name")
    public String firstName;

    @JsonProperty("last_name")
    public String lastName;
    
    @JsonProperty("birthday")
    public Date birthday;

    @JsonProperty("email_address")
    public String emailAddress;

    @JsonProperty("mobile_number")
    public String mobileNumber;

    @JsonProperty("home_address")
    public String homeAddress;

    @JsonProperty("notes")
    public String notes;

    @JsonProperty("create_date_time")
    public String createDateTime;

    public Card(){}
    
    public Card
    (
        String firstName, 
        String lastName, 
        String birthday, 
        String emailAddress, 
        String mobileNumber, 
        String homeAddress, 
        String notes
    )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = Date.valueOf(birthday);
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
        this.homeAddress = homeAddress;
        this.notes = notes;
    }

}
