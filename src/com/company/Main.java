package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Functions db = new Functions();
        String name = "dbProject";
        String username = "postgres";
        String password = "12073";
        db.connection_toDB(name, username, password);

        // Call CRUD operations
        db.insertData(db.connection_toDB(name, username, password), "Books", new String[]{"BookID", "Title", "ISBN", "AuthorID", "StockQuantity", "Price", "PublicationDate"}, new String[]{"1", "Harry Potter and the Sorcerer's Stone", "9780439554930", "1", "100", "24.99", "1997-06-26"});

        // Call Transaction

        // Call Metadata Access
    }
}

