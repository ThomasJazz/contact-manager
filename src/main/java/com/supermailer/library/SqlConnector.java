package com.supermailer.library;

import java.util.Properties;
import java.util.ArrayList;
import java.sql.*;
import com.google.gson.*;
//import com.google.gson.Gson;

//import org.springframework.core.env.Environment;

public class SqlConnector 
{
    private String url;
    private Properties connectionProps;

    /**
     * Because I'm only using this class for this project currently, I'm going to have url and the connection
     * properties defined here in the constructor so I don't have to set up all these values in each API endpoint
     */
    public SqlConnector()
    {
        this.url = "jdbc:postgresql://localhost/super_mailer";
        this.connectionProps = new Properties();
        this.connectionProps.setProperty("user", "postgres");
        this.connectionProps.setProperty("password", System.getenv("SUPERMAILER_POSTGRES_PASSWORD"));
        this.connectionProps.setProperty("ssl", "false");
    }

    /**
     * Creates and returns a Connection object using this.url and this.connectionProps
     * @return java.sql.Connection object
     * @throws SQLException
     */
    public Connection GetConnection() throws SQLException
    {
        return DriverManager.getConnection(this.url, this.connectionProps);
    }

    // public String getQueryJson(String query) throws SQLException
    // {
        
    // }

    /**
     * Executes the provided query string and returns the result set in a JsonArray
     * @param query The query to execute
     * @return JsonArray of the ResultSet
     * @throws SQLException
     */
    public JsonArray getQueryJsonArray(String query) throws SQLException
    {
        JsonArray array = new JsonArray();

        try (Connection conn = this.GetConnection(); 
            PreparedStatement ps = conn.prepareStatement(query); 
            ResultSet rs = ps.executeQuery();)
        {
            while (rs.next())
            {
                ResultSetMetaData rsmd = rs.getMetaData();
                int totalCols = rsmd.getColumnCount();

                JsonObject obj = new JsonObject();
                for (int i = 1; i <= totalCols; i++)
                {
                    obj.addProperty(rsmd.getColumnName(i), rs.getString(i));
                }

                array.add(obj);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error occurred while executing SQL query " + e.getMessage());
        }

        return array;
    }

    /********* QUERY STRING FORMATTING/MANIPULATION *********/
    public static String formatQuery(String query, ArrayList<String> formatArgs)
    {
        String finalQuery = String.format(query, formatArgs.get(0));

        return finalQuery;
    }
}
