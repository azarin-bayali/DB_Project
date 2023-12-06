package com.company;

import java.sql.*;
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


    //Selecting books
    public void selectBook(int bookID) {
        try {
            Connection con = connection_toDB("dbProject", "postgres", "12073");
            String sql = "SELECT * FROM Books WHERE BookID = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, bookID);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        // Process and print book details
                        int retrievedBookID = rs.getInt("BookID");
                        String title = rs.getString("Title");
                        String isbn = rs.getString("ISBN");
                        int authorID = rs.getInt("AuthorID");
                        int stockQuantity = rs.getInt("StockQuantity");
                        double price = rs.getDouble("Price");
                        String publicationDate = rs.getString("PublicationDate");

                        System.out.println("BookID: " + retrievedBookID);
                        System.out.println("Title: " + title);
                        System.out.println("ISBN: " + isbn);
                        System.out.println("AuthorID: " + authorID);
                        System.out.println("StockQuantity: " + stockQuantity);
                        System.out.println("Price: " + price);
                        System.out.println("PublicationDate: " + publicationDate);
                    } else {
                        System.out.println("Book with ID " + bookID + " not found.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error selecting book: " + e.getMessage());
        }
    }
}



