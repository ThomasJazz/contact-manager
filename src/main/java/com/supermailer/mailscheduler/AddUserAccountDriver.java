package com.supermailer.mailscheduler;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.reflect.Type;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.google.gson.Gson;
import com.google.gson.*;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.supermailer.library.*;
import com.supermailer.mailscheduler.model.UserAccount;

@RestController
public class AddUserAccountDriver 
{
    public static String funcAddUserQuery = "SELECT func_add_user_account AS user_account_id FROM func_add_user_account('%s', '%s', '%s', '%s', '%s', '%s', '%s')";
    public static Gson gson = new GsonBuilder().serializeNulls().create();

    @PostMapping("/add-user")
    public UserAccount userAccount
    (
        @RequestParam(value = "firstName", defaultValue="") String firstName,
        @RequestParam(value = "lastName", defaultValue="") String lastName,
        @RequestParam(value = "birthday", defaultValue="") String birthday,
        @RequestParam(value = "email", defaultValue="") String emailAddress,
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
        UserAccount account = new UserAccount(firstName, lastName, birthday, emailAddress, mobileNumber, address, notes);
        
        // Creatr sql object for creating and querying
        SqlConnector sql = new SqlConnector();
        String query = getAddUserQuery(account);
        
        // Execute query and get results in JSON string
        JsonArray json = sql.getQueryJsonArray(query);
        
        // Attempt to grab the returned ID from the JSON string
        try
        {
            UserAccount acc = gson.fromJson(json.getAsJsonObject(), UserAccount.class);
            //ArrayList<UserAccount> accounts = gson.fromJson(json, new TypeToken<ArrayList<UserAccount>>(){}.getType());
            //UserAccount tempAccount = accounts.get(0);
            account.userAccountId = acc.userAccountId;
            System.out.println(account.userAccountId);
        }
        catch (Exception e)
        {
            System.out.println("Error occurred mapping JSON to UserAccount object: " + e.getMessage());
        }
        
        System.out.println();

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
            account.emailAddress, 
            account.notes
        );
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "firstName cannot be empty")
    public class FirstNameEmptyException extends RuntimeException {}
}
