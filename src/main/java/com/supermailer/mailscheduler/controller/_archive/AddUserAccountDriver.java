// package com.supermailer.mailscheduler.controller._archive;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import javax.validation.constraints.NotBlank;
// import org.springframework.lang.NonNull;
// import java.lang.reflect.Type;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.http.HttpStatus;
// import com.google.gson.Gson;
// import com.google.gson.*;
// import com.google.gson.GsonBuilder;
// import com.supermailer.library.*;
// import com.supermailer.mailscheduler.model.*;

// @RestController
// public class AddUserAccountDriver 
// {
//     public SqlConnector sql = new SqlConnector();
//     public static String funcAddUserQuery = "SELECT func_add_user_account AS user_account_id FROM func_add_user_account('%s', '%s', '%s', '%s', '%s', '%s', '%s')";
//     public static Gson gson = new GsonBuilder().serializeNulls().create();
    
//     @PostMapping("/add-user")
//     public UserAccount userAccount
//     (
//         @NonNull @NotBlank @RequestParam(value = "first_name", defaultValue="") String firstName,
//         @RequestParam(value = "last_name", defaultValue="") String lastName,
//         @RequestParam(value = "birthday", defaultValue="") String birthday,
//         @RequestParam(value = "email", defaultValue="") String emailAddress,
//         @RequestParam(value = "mobile_number", defaultValue="") String mobileNumber,
//         @RequestParam(value = "home_address", defaultValue="") String homeAddress,
//         @RequestParam(value = "notes", defaultValue="") String notes
//     ) throws SQLException
//     {
//         // Body
//         UserAccount account = new UserAccount(firstName, lastName, birthday, emailAddress, mobileNumber, homeAddress, notes);
        
//         System.out.println("/add-user processing request:");
//         System.out.println(gson.toJson(account));

//         // Creatr sql object for creating and querying
//         String query = getAddUserQuery(account);
        
//         // Execute query and get results in JSON string
//         JsonArray json = sql.getQueryJsonArray(query);
        
//         // Attempt to grab the returned ID from the JSON string
//         try
//         {
//             JsonObject obj = json.get(0).getAsJsonObject();
//             account.userAccountId = obj.get("user_account_id").getAsString();

//             System.out.println(account.userAccountId);
//         }
//         catch (Exception e)
//         {
//             System.out.println("Error occurred mapping JSON to UserAccount object: " + e.getMessage());
//         }
        
//         return account;
//     }

//     public static String getAddUserQuery(UserAccount account)
//     {
//         return String.format(
//             funcAddUserQuery,
//             account.firstName, 
//             account.lastName, 
//             account.birthday, 
//             account.mobileNumber, 
//             account.homeAddress, 
//             account.emailAddress, 
//             account.notes
//         );
//     }
// }
