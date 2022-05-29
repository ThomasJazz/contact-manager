package com.supermailer.mailscheduler.userAccount;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.supermailer.sqlConnector.*;

@RestController
public class AddUserAccountDriver 
{
    @PostMapping("/add-user")
    public UserAccount userAccount(
        @RequestParam(value = "firstName", defaultValue="") String firstName,
        @RequestParam(value = "lastName", defaultValue="") String lastName,
        @RequestParam(value = "birthday", defaultValue="") String birthday,
        @RequestParam(value = "email", defaultValue="") String email,
        @RequestParam(value = "mobileNumber", defaultValue="") String mobileNumber,
        @RequestParam(value = "address", defaultValue="") String address,
        @RequestParam(value = "notes", defaultValue="") String notes
    )
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
        

        return account;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "firstName cannot be empty")
    public class FirstNameEmptyException extends RuntimeException {}
}
