package com.company;

import java.sql.*;

//Connecting to Database
public class Functions {
    public Connection connection_toDB(String dbName, String username, String password) {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, username, password);
            if (con != null) System.out.println("Connection made!");
            else System.out.println("Connection failed!");
        } catch (Exception e) {
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

    // 2. Retrieving all book information, including authors and associated orders
    //There is an error here and since my pgadmin does not work I cannot resolve it
//    public void getAllBookInfo() {
//            try {
//                Connection con = connection_toDB("dbProject", "postgres", "12073");
//                String sql = "SELECT * FROM Books " +
//                        "JOIN Authors ON Books.AuthorID = Authors.AuthorID " +
//                        "LEFT JOIN Orders_Books ON Books.BookID = Orders_Books.BookID " +
//                        "LEFT JOIN Orders ON Orders_Books.OrderID = Orders.OrderID";
//                try (Statement stmt = con.createStatement();
//                     ResultSet rs = stmt.executeQuery(sql)) {
//                    while (rs.next()) {
//                        int bookID = rs.getInt("Books.BookID"); // Corrected
//                        String title = rs.getString("Books.Title");
//                        String isbn = rs.getString("Books.ISBN");
//                        int authorID = rs.getInt("Books.AuthorID"); // Corrected
//                        String authorName = rs.getString("Authors.AuthorName");
//                        int stockQuantity = rs.getInt("Books.StockQuantity");
//                        double price = rs.getDouble("Books.Price");
//                        java.sql.Date publicationDate = rs.getDate("Books.PublicationDate");
//                        int orderID = rs.getInt("Orders.OrderID");
//                        java.sql.Date orderDate = rs.getDate("Orders.OrderDate");
//                        double totalAmount = rs.getDouble("Orders.TotalAmount");
//                        String status = rs.getString("Orders.Status");
//
//                        System.out.println("BookID: " + bookID);
//                        System.out.println("Title: " + title);
//                        System.out.println("ISBN: " + isbn);
//                        System.out.println("AuthorID: " + authorID);
//                        System.out.println("AuthorName: " + authorName);
//                        System.out.println("StockQuantity: " + stockQuantity);
//                        System.out.println("Price: " + price);
//                        System.out.println("PublicationDate: " + publicationDate);
//                        System.out.println("OrderID: " + orderID);
//                        System.out.println("OrderDate: " + orderDate);
//                        System.out.println("TotalAmount: " + totalAmount);
//                        System.out.println("Status: " + status);
//                        System.out.println();
//                    }
//                }
//            } catch (SQLException e) {
//                System.out.println("Error retrieving book information: " + e.getMessage());
//            }
//        }
//    }

    // 3. Updating details of a book
    public void updateBookDetails(int bookID, String newTitle, int newStockQuantity, double newPrice) {
        try {
            Connection con = connection_toDB("dbProject", "postgres", "12073");
            String sql = "UPDATE Books SET Title = ?, StockQuantity = ?, Price = ? WHERE BookID = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, newTitle);
                pstmt.setInt(2, newStockQuantity);
                pstmt.setDouble(3, newPrice);
                pstmt.setInt(4, bookID);
                pstmt.executeUpdate();
                System.out.println("Book details updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error updating book details: " + e.getMessage());
        }
    }

    // 4. Removing an existing book
    public void removeBook(int bookID) {
        try {
            Connection con = connection_toDB("dbProject", "postgres", "12073");
            String sql = "DELETE FROM Books WHERE BookID = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, bookID);
                pstmt.executeUpdate();
                System.out.println("Book removed successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error removing book: " + e.getMessage());
        }
    }
}
