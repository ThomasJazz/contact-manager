package com.thomasjazz.contactmanager.helper;
import java.util.*;
import java.lang.reflect.*;
import com.google.gson.Gson;
import com.google.gson.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
// import com.supermailer.mailscheduler.userAccount.UserAccount;

public class Helper 
{
    public static String getJsonProperty(String json, String propertyName)
    {
        JsonObject obj = new Gson().fromJson(json, JsonObject.class);
        return obj.get(propertyName).toString();
    }

    public static <T> ArrayList<T> fromJsonArray(String json, Class<T> classT)
    {
        Type listClassType = new TypeToken<ArrayList<T>>(){}.getType();
        ArrayList<T> obj = new Gson().fromJson(json, listClassType);

        return obj;
    }

    public static <T> T fromJson (String json, Class<T> type)
    {
        return new Gson().fromJson(json, type);
    }
}
