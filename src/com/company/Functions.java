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
    // 1. Inserting new records
    public void insertBook(String title, String isbn, int authorID, int stockQuantity, double price, String publicationDate) {
        try {
            Connection con = connection_toDB("dbProject", "postgres", "12073");
            String sql = "INSERT INTO Books (Title, ISBN, AuthorID, StockQuantity, Price, PublicationDate) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, title);
                pstmt.setString(2, isbn);
                pstmt.setInt(3, authorID);
                pstmt.setInt(4, stockQuantity);
                pstmt.setDouble(5, price);
                pstmt.setDate(6, java.sql.Date.valueOf(publicationDate));
                pstmt.executeUpdate();
                System.out.println("Book inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting book: " + e.getMessage());
        }
    }



//Transaction Operations



//Metadata Access
}



