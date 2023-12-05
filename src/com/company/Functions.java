package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

//Connecting to Database
public class Functions {
    public Connection connection_toDB(String dbName, String username, String password){
        Connection con = null;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, username, password);
            if(con != null) System.out.println("Connection made!");
            else System.out.println("Connection failed!");
        }catch (Exception e){
            System.out.println(e);
        }

         return con;
    }
    //CRUD Operations
    public void insertData(Connection connection, String tableName, String[] columns, String[] values) {

        String[] formattedValues = Arrays.stream(values)
                .map(value -> "'" + value + "'")
                .toArray(String[]::new);

        String insertCommand = "INSERT INTO " + tableName + " (" + String.join(", ", columns) + ") VALUES (" + String.join(", ", formattedValues) + ")";
        System.out.println("INSERT command: " + insertCommand);

        try (PreparedStatement statement = connection.prepareStatement(insertCommand)) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Failed to insert data.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

        }

    }


//Transaction Operations



//Metadata Access
}



