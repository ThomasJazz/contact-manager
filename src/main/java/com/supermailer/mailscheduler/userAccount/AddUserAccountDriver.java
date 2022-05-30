package com.supermailer.mailscheduler.userAccount;
import org.springframework.web.bind.annotation.*;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;

import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.supermailer.library.*;

@RestController
public class AddUserAccountDriver 
{
    public static String funcAddUserQuery = "SELECT * FROM func_add_user_account('%s', '%s', '%s', '%s', '%s', '%s', '%s')";

    @PostMapping("/add-user")
    public UserAccount userAccount
    (
        @RequestParam(value = "firstName", defaultValue="") String firstName,
        @RequestParam(value = "lastName", defaultValue="") String lastName,
        @RequestParam(value = "birthday", defaultValue="") String birthday,
        @RequestParam(value = "email", defaultValue="") String email,
        @RequestParam(value = "mobileNumber", defaultValue="") String mobileNumber,
        @RequestParam(value = "address", defaultValue="") String address,
        @RequestParam(value = "notes", defaultValue="") String notes
    ) throws SQLException
    {
        // Check for only required field and throw exception if its empty
        if (firstName.isEmpty())
        {
            throw new FirstNameEmptyException();
        }

        // Body
        UserAccount account = new UserAccount(firstName, lastName, birthday, email, mobileNumber, address, notes);
        System.out.println("Received account creation request for " + account.firstName + " " + account.lastName);
        
        // Creatr sql object for creating and querying
        SqlConnector sql = new SqlConnector();
        String query = getAddUserQuery(account);
        
        // Execute query and get results in JSON string
        String json = sql.getQueryJson(query);
        
        // Attempt to grab the returned ID from the JSON string
        // try
        // {
        //     account.id = MethodHelper.convertJsonToObject(json, UserAccount.class).id;
        // }
        // catch (JsonProcessingException e)
        // {
        //     System.out.println("Error occurred mapping JSON to UserAccount object: " + e.getMessage());
        // }

        System.out.println(json);
        return account;
    }

    public static String getAddUserQuery(UserAccount account)
    {
        return String.format(
            funcAddUserQuery,
            account.firstName, 
            account.lastName, 
            account.birthday, 
            account.mobileNumber, 
            account.address, 
            account.email_address, 
            account.notes
        );
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "firstName cannot be empty")
    public class FirstNameEmptyException extends RuntimeException {}
}
