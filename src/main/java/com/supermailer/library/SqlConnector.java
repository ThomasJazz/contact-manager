package com.supermailer.library;

import java.util.Properties;
import java.sql.*;
import java.io.FileReader;
import com.fasterxml.jackson.core.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.*;

//import org.springframework.core.env.Environment;

@SuppressWarnings("unchecked")
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

    /**
     * 
     * @param query
     * @return
     * @throws SQLException
     */
    public String getQueryJson(String query) throws SQLException
    {
        JSONArray json = new JSONArray();

        try (Connection conn = this.GetConnection(); 
            PreparedStatement ps = conn.prepareStatement(query); 
            ResultSet rs = ps.executeQuery();)
        {
            ResultSetMetaData rsmd = rs.getMetaData();
            
            // Parse through query and put it into JSONArray object
            while(rs.next()) 
            {
                int numColumns = rsmd.getColumnCount();
                JSONObject obj = new JSONObject();
                
                for (int i = 1; i <= numColumns; i++) 
                {
                    String column_name = rsmd.getColumnName(i);
                    obj.put(column_name, rs.getObject(column_name));
                }

                json.add(obj);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error occurred while executing SQL query " + e.getMessage());
        }

        return json.toJSONString();
    }

    // TODO: public String getQueryHashMap(String query) throws SQLException


    public String getStoredProcedureJson(String procedure, String[] spArgs)
    {
        String results = "";


        return results;
    }
}
