package com.supermailer.mailscheduler.controller;
import java.sql.SQLException;
import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import com.google.gson.*;
import com.google.gson.GsonBuilder;
import com.supermailer.library.*;
import com.supermailer.mailscheduler.model.*;

@RestController
public class AddContactDriver 
{
    public SqlConnector sql = new SqlConnector();

    public static String funcAddContactQuery = "SELECT func_add_contact AS contact_id FROM func_add_contact(%s, '%s', '%s', '%s', '%s', '%s', '%s', '%s')";
    public static Gson gson = new GsonBuilder().serializeNulls().create();

    @PostMapping("/add-contact")
    public Contact contact(
        @NonNull @NotBlank @RequestParam(value = "user_account_id", defaultValue = "") String userAccountId,
        @NonNull @NotBlank @RequestParam(value = "first_name", defaultValue="") String firstName,
        @RequestParam(value = "last_name", defaultValue="") String lastName,
        @RequestParam(value = "birthday", defaultValue="") String birthday,
        @RequestParam(value = "email", defaultValue="") String emailAddress,
        @RequestParam(value = "mobile_number", defaultValue="") String mobileNumber,
        @RequestParam(value = "home_address", defaultValue="") String homeAddress,
        @RequestParam(value = "notes", defaultValue="") String notes
    ) throws SQLException
    { 
        Contact contact = new Contact(userAccountId, 
            firstName, 
            lastName, 
            birthday, 
            emailAddress, 
            mobileNumber, 
            homeAddress, 
            notes
        );
        
        String query = getAddContactQuery(contact);
        
        // Execute query and get results in JSON string
        JsonArray json = sql.getQueryJsonArray(query);
        
        // Attempt to grab the returned ID from the JSON string
        try
        {
            JsonObject obj = json.get(0).getAsJsonObject();
            contact.contactId = obj.get("contact_id").getAsString();

            System.out.println(contact.contactId);
        }
        catch (Exception e)
        {
            System.out.println("Error occurred mapping JSON to Contact object: " + e.getMessage());
        }
        
        return contact;
    }

    public static String getAddContactQuery(Contact contact)
    {
        return String.format(
            funcAddContactQuery,
            contact.userAccountId,
            contact.firstName, 
            contact.lastName, 
            contact.birthday, 
            contact.mobileNumber, 
            contact.homeAddress, 
            contact.emailAddress, 
            contact.notes
        );
    }
}
