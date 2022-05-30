package com.supermailer.mailscheduler.userAccount;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.sql.SQLException;

import com.supermailer.sqlConnector.*;

@RestController
public class AddUserAccountDriver 
{
    public String insertUserQuery = "INSERT INTO user_account" +
        "(first_name, last_name, birthday, mobile_number, home_address, email_address, notes)" +
        " VALUES (%s, %s, %s, %s, %s, %s, %s);";

    public String addUserSp = "CALL sp_add_user_account({0}, {1}, {2}, {3}, {4}, {5}, {6}";

    @PostMapping("/add-user")
    public UserAccount userAccount(
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
        
        SqlConnector sql = new SqlConnector("jdbc:postgresql://localhost/super_mailer");
        sql.Connect();
        String query = buildQuery(account);
        
        sql.GetQueryJson(query);
        return account;
    }

    public String buildQuery(UserAccount account)
    {
        return String.format(
            this.insertUserQuery, 
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
