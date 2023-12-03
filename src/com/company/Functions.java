package com.company;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;


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
}
