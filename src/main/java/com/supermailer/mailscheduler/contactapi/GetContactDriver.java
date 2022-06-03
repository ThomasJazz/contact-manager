package com.supermailer.mailscheduler.contactapi;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import com.google.gson.*;
import com.google.gson.GsonBuilder;
import com.supermailer.library.*;
import com.supermailer.mailscheduler.model.*;

@RestController
public class GetContactDriver 
{
    @GetMapping("/get-user-contacts")
    public ArrayList<Contact> getContacts(@NonNull @NotBlank @RequestParam(value = "user_account_id") int userAccountId)
    {
        ArrayList<Contact> contacts = new ArrayList<>();

        return contacts;
    }
}
