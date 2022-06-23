package com.supermailer.mailscheduler.entity;
import java.lang.reflect.*;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.annotations.*;
import com.google.gson.reflect.TypeToken;

import javax.validation.constraints.NotBlank;
//import org.springframework.lang.NonNull;
//import org.springframework.lang.*;


public class UserAccount extends Card
{
    @JsonProperty("user_account_id")
    public String userAccountId = null;
    
}
