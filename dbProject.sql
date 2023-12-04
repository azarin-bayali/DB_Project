CREATE TABLE Customers (
    CustomerID SERIAL PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Email VARCHAR(255),
    PhoneNumber VARCHAR(15),
    Address TEXT
);

CREATE TABLE Genres (
    GenreID SERIAL PRIMARY KEY,
    GenreName VARCHAR(255)
);

CREATE TABLE Books (
    BookID SERIAL PRIMARY KEY,
    Title VARCHAR(255),
    ISBN VARCHAR(13),
    AuthorID INT,
    StockQuantity INT,
    Price DECIMAL(10, 2),
    PublicationDate DATE,
    FOREIGN KEY (AuthorID) REFERENCES Authors(AuthorID)
);

CREATE TABLE Orders (
    OrderID SERIAL PRIMARY KEY,
    CustomerID INT,
    OrderDate DATE,
    TotalAmount DECIMAL(10, 2),
    Status VARCHAR(20),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);