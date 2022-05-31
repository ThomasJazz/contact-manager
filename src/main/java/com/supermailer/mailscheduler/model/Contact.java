package com.supermailer.mailscheduler.model;
import com.fasterxml.jackson.annotation.*;

public class Contact extends Card
{
    @JsonProperty("user_id")
    public String userId;

    public Contact(String userId, String firstName, String lastName, String birthday, String emailAddress, String mobileNumber, String address, String notes)
    {
        super(firstName, lastName, birthday, emailAddress, mobileNumber, address, notes);
        this.userId = userId;
    }
}