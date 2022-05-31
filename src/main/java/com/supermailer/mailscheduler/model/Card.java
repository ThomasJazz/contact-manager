package com.supermailer.mailscheduler.model;
import com.fasterxml.jackson.annotation.*;
import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;


public abstract class Card 
{
    @JsonProperty("first_name")
    public String firstName;

    @JsonProperty("last_name")
    public String lastName;
    
    @JsonProperty("birthday")
    public String birthday;

    @JsonProperty("email_address")
    public String emailAddress;

    @JsonProperty("mobile_number")
    public String mobileNumber;

    @JsonProperty("address")
    public String address;

    @JsonProperty("notes")
    public String notes;

    public Card(){}
    
    public Card(String firstName, 
        String lastName, 
        String birthday, 
        String emailAddress, 
        String mobileNumber, 
        String address, 
        String notes
    )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.notes = notes;
    }

}
