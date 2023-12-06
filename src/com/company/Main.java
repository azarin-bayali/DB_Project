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
        //Call insertion
        db.insertBook("The Great Gatsby", "9780142437266", 1, 100, 25.99, "2022-01-01");

        // Call Transaction

        // Call Metadata Access


        
    }
}

