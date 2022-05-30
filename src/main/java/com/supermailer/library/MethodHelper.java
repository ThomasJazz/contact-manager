package com.supermailer.library;
import java.util.*;
import java.lang.reflect.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MethodHelper 
{
    public static <T> T convertJsonToObject(String json, Class<T> type) throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();

        T obj = mapper.readValue(json, type);

        return obj;
    }
}
