package com.supermailer.mailscheduler.model;
import java.util.*;
import com.fasterxml.jackson.annotation.*;
import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

//@JsonInclude(Include.NON_NULL)
public class Contact extends Card
{
    @JsonProperty("contact_id")
    public String contactId;
    
    @JsonProperty("user_contact_id")
    public String userAccountId;

    public Contact()
    {
        super();
        this.contactId = null;
    }

    public Contact (
        String userAccountId,
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

    
}