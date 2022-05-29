package com.supermailer.sqlConnector;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

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
        this.connProps.setProperty("ssl","false");
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
}
