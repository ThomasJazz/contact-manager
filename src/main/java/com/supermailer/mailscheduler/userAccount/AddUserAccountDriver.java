package com.supermailer.mailscheduler.userAccount;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.reflect.Type;
import org.springframework.web.bind.annotation.*;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.supermailer.library.*;

@RestController
public class AddUserAccountDriver 
{
    public static String funcAddUserQuery = "SELECT func_add_user_account AS id FROM func_add_user_account('%s', '%s', '%s', '%s', '%s', '%s', '%s')";
    public static Gson gson = new Gson();

    @PostMapping("/add-user")
    public UserAccountDTO userAccount
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
        UserAccountDTO account = new UserAccountDTO(firstName, lastName, birthday, email, mobileNumber, address, notes);
        
        // Creatr sql object for creating and querying
        SqlConnector sql = new SqlConnector();
        String query = getAddUserQuery(account);
        
        // Execute query and get results in JSON string
        String json = sql.getQueryJson(query).toJSONString();
        
        // Attempt to grab the returned ID from the JSON string
        try
        {
            ArrayList<UserAccountDTO> accounts = gson.fromJson(json, new TypeToken<ArrayList<UserAccountDTO>>(){}.getType());
            account.id = accounts.get(0).id;
        }
        catch (Exception e)
        {
            System.out.println("Error occurred mapping JSON to UserAccount object: " + e.getMessage());
        }

        System.out.println(gson.toJson(account));

        return account;
    }

    public static String getAddUserQuery(UserAccountDTO account)
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
