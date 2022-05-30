package com.supermailer.sqlConnector;
import java.util.*;
import java.util.Properties;
import java.sql.*;
import com.fasterxml.jackson.core.json.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.*;

import java.io.FileReader;

//import org.springframework.core.env.Environment;

public class SqlConnector 
{
    private String url;
    private Properties connProps;
    private Connection sqlConn;

    public SqlConnector(String url)
    {
        this.url = url;
        this.connProps = new Properties();
        this.connProps.setProperty("user", "postgres");
        this.connProps.setProperty("password", System.getenv("SUPERMAILER_POSTGRES_PASSWORD"));
        this.connProps.setProperty("ssl", "false");
        this.Connect();
    }

    public void Connect()
    {
        try
        {
            this.sqlConn = DriverManager.getConnection(this.url, this.connProps);
        }
        catch (SQLException e)
        {
            System.out.println("Something went wrong while connecting to SQL database!: " + e.getMessage());
        }
    }

    public String GetQueryJson(String query) throws SQLException
    {
        JSONArray json = new JSONArray();
        Statement st = this.sqlConn.createStatement();
        ResultSet rs = st.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        while(rs.next()) {
            int numColumns = rsmd.getColumnCount();
            JSONObject obj = new JSONObject();
            for (int i=1; i<=numColumns; i++) {
                String column_name = rsmd.getColumnName(i);
                obj.put(column_name, rs.getObject(column_name));
            }
            json.add(obj);
        }
        return json.toJSONString();
    }

    public String getStoredProcedureJson(String procedure, String[] spArgs)
    {
        String results = "";


        return results;
    }
}
