package com.supermailer.mailscheduler.model;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class Contact extends Card
{
    @JsonProperty("user_account_id")
    public String userAccountId;

    public Contact(String userAccountId, String firstName, String lastName, String birthday, String emailAddress, String mobileNumber, String address, String notes)
    {
        super(firstName, lastName, birthday, emailAddress, mobileNumber, address, notes);
        this.userAccountId = userAccountId;
    }
}