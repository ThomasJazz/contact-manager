package com.supermailer.mailscheduler.model;
import java.util.*;
import com.fasterxml.jackson.annotation.*;
import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

// For JPA mapping to DB
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.ForeignKey;
// import javax.persistence.Column;

//@JsonInclude(Include.NON_NULL)
public class Contact extends Card
{
    @JsonProperty("user_account_id")
    public String userAccountId;

    @JsonProperty("user_contact_id")
    public String contactId;

    // Exists only for the sake of JPA
    protected Contact(){}

    public Contact (
        String userAccountId,
        String firstName, 
        String lastName, 
        String birthday, 
        String emailAddress, 
        String mobileNumber, 
        String homeAddress, 
        String notes
    )
    {
        super(firstName, lastName, birthday, emailAddress, mobileNumber, homeAddress, notes);
        this.userAccountId = userAccountId;
    }
}